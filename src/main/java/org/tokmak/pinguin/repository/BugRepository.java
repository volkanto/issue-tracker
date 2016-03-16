package org.tokmak.pinguin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tokmak.pinguin.model.Bug;

/**
 * <b>Project issue-tracker</b><br />
 * BugRepository.java<br />
 *
 * <b>created at</b> Mar 1, 2016 11:19:50 PM
 * 
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface BugRepository extends JpaRepository<Bug, Integer>
{
	@Query(value="from Bug b where b.developer.id is null order by b.issueId asc")
	public List<Bug> findUnassigned();

	@Override
	@Query(value="from Bug b order by b.issueId asc")
	public List<Bug> findAll();

	@Query(value="from Bug b where b.developer.id = :developerId order by b.issueId asc")
	public List<Bug> getBugsBy(@Param(value = "developerId") Integer argDeveloperId);
}
