package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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

}