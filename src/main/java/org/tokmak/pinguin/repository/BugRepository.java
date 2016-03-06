package org.tokmak.pinguin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	@Query(value = "SELECT * FROM BUG WHERE ISSUEID NOT IN (SELECT B.ISSUEID FROM BUG B LEFT JOIN DEVELOPER_BUG DB ON DB.ISSUEID = B.ISSUEID WHERE B.ISSUEID = DB.ISSUEID)", nativeQuery = true)
	public List<Bug> findUnassigned();

	@Query(value="from Bug b order by b.issueId asc")
	@Override
	public List<Bug> findAll();
}
