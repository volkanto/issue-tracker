package org.tokmak.pinguin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tokmak.pinguin.model.Story;

/**
 * <b>Project issue-tracker</b><br />
 * StoryRepository.java<br />
 *
 * <b>created at</b> Mar 6, 2016 5:19:01 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface StoryRepository extends JpaRepository<Story, Integer>
{
	@Query(value = "SELECT * FROM STORY WHERE ISSUEID NOT IN (SELECT S.ISSUEID FROM STORY S LEFT JOIN DEVELOPER_STORY DS ON DS.ISSUEID = S.ISSUEID WHERE S.ISSUEID = DS.ISSUEID)", nativeQuery = true)
	public List<Story> findUnassigned();

	@Override
	@Query(value="from Story b order by b.issueId asc")
	public List<Story> findAll();
	
	@Query(value = "select d.developerid as developerId, sum(sp.pointvalue) as points from story s left join developer_story ds on ds.issueid = s.issueid left join developer d on d.developerid = ds.developerid inner join story_point sp on sp.storypointid = s.point_storypointid where s.issueid in :issueIds group by d.developerid", nativeQuery = true)
	public List<Object[]> findStoryPointOfDevelopers(@Param("issueIds") List<Integer> argStoryIdList);
}