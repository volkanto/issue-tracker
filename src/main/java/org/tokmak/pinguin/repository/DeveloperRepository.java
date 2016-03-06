package org.tokmak.pinguin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tokmak.pinguin.model.Developer;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperRepository.java<br />
 *
 * <b>created at</b> Feb 28, 2016 1:33:45 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface DeveloperRepository extends JpaRepository<Developer, Integer>
{
	@Query("FROM Developer d where d.name = :argName")
    public Developer findByName(@Param(value = "argName") String argName);
	
	@Query("FROM Developer d where d.active = true")
	@Override
	public List<Developer> findAll();
}