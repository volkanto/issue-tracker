package org.tokmak.pinguin.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Sprint;
import org.tokmak.pinguin.model.Story;
import org.tokmak.pinguin.repository.SprintRepository;

/**
 * <b>Project issue-tracker</b><br />
 * SprintService.java<br />
 *
 * <b>created at</b> Mar 5, 2016 7:22:33 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Service
@Transactional
public class SprintService
{
	@Autowired private SprintRepository sprintRepository;
	@Autowired private StoryService storyService;
	@Autowired private DeveloperService developerService; 
	
	/**
	 * SprintService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 7:23:16 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Sprint> listAll()
	{
		return this.sprintRepository.findAll();
	}

	/**
	 * SprintService<br />
	 *
	 * @param argSprint
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 7:35:43 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Sprint create(Sprint argSprint)
	{
		argSprint.setId(null);
		return this.sprintRepository.saveAndFlush(argSprint);
	}

	/**
	 * SprintService<br />
	 *
	 * @param argSprintId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 8:05:59 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Sprint getInformation(Integer argSprintId)
	{
		return this.sprintRepository.findOne(argSprintId);
	}

	/**
	 * SprintService<br />
	 *
	 * @param argSprintId
	 * @param argSprint
	 * @return
	 * 
	 * <b>created at</b> Mar 13, 2016 12:19:12 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Sprint update(Integer argSprintId, Sprint argSprint)
	{
		Sprint sprint = this.sprintRepository.findOne(argSprintId);
		if(sprint == null) {
			throw new IllegalArgumentException("Choose correct sprint!");			
		}
		sprint.setTitle(argSprint.getTitle());
		sprint.setDescription(argSprint.getDescription());
		
		return this.sprintRepository.saveAndFlush(sprint);
	}
	
	/**
	 * SprintService<br />
	 *
	 * @param argSprintId
	 * @param argStoryId
	 * 
	 * <b>created at</b> Mar 13, 2016 12:31:13 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void assign(Integer argSprintId, Integer argStoryId)
	{
		Sprint sprint = this.getInformation(argSprintId);
		if(sprint == null) {
			throw new IllegalArgumentException("Choose correct sprint!");
		}
		
		HashMap<String, Double> developerPointMap = new HashMap<>();
		
		List<Story> developerStories = this.storyService.getDeveloperStoryListBy(argSprintId);
		developerStories.stream().forEach(item -> {
			Double value = developerPointMap.get(item.getDeveloper().getName());
			if(value != null) {
				developerPointMap.put(item.getDeveloper().getName(), item.getPoint().getValue() + value);
			} else {
				developerPointMap.put(item.getDeveloper().getName(), item.getPoint().getValue());
			}
		});
		
		for (Entry<String, Double> developerStory : developerPointMap.entrySet()) {
			if(developerStory.getValue() > 10) {
				throw new IllegalArgumentException("Developer with name: " + developerStory.getKey() + " has more than 10 story point for current sprint!");
			}
		}
		
		Integer totalDeveloperSize = this.developerService.count();
		Double totalSprintPoint = this.storyService.getPointBy(argSprintId);
		
		if(totalSprintPoint > totalDeveloperSize * 10) {
			throw new IllegalArgumentException("Maximum sprint story point error! You can define maximum " + totalDeveloperSize * 10 + " points. You have " + totalSprintPoint);
		}
		
		
		Story story = this.storyService.findBy(argStoryId);
		if(story == null) {
			throw new IllegalArgumentException("Choose correct stories!");	
		}
		story.setSprint(sprint);
		this.storyService.update(story.getIssueId(), story);
		
		sprint.setStories(Arrays.asList(story));
		this.sprintRepository.saveAndFlush(sprint);
	}
}
