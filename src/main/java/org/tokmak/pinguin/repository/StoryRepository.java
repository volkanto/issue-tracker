package org.tokmak.pinguin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tokmak.pinguin.model.Sprint;
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
	@Query(value="from Story s where s.developer.id is null order by s.issueId asc")
	public List<Story> findUnassigned();

	@Override
	@Query(value="from Story s order by s.issueId asc")
	public List<Story> findAll();
	
	@Query(value="from Story s where s.developer.id = :developerId order by s.issueId asc")
	public List<Story> getStoriesBy(@Param(value = "developerId") Integer argDeveloperId);

	@Query(value="from Story s where s.sprint.id is null and s.point.value is not null order by s.issueId asc")
	public List<Sprint> findUnassignedSprintStories();

	@Query(value="from Story s where s.sprint.id = :sprintId")
	public List<Story> getDeveloperStoryListBy(@Param(value = "sprintId") Integer argSprintId);

	@Query(value="select count(s.point.value) from Story s where s.sprint.id = :sprintId")
	public Double getPointBy(@Param(value = "sprintId") Integer argSprintId);
}