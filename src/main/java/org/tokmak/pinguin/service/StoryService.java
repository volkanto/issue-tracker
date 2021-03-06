package org.tokmak.pinguin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Developer;
import org.tokmak.pinguin.model.Sprint;
import org.tokmak.pinguin.model.Story;
import org.tokmak.pinguin.model.StoryPoint;
import org.tokmak.pinguin.model.StoryStatus;
import org.tokmak.pinguin.repository.StoryPointRepository;
import org.tokmak.pinguin.repository.StoryRepository;
import org.tokmak.pinguin.repository.StoryStatusRepository;

/**
 * <b>Project issue-tracker</b><br />
 * StoryService.java<br />
 *
 * <b>created at</b> Mar 6, 2016 2:14:13 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Service
@Transactional
public class StoryService
{
	@Autowired private StoryRepository storyRepo;
	@Autowired private StoryStatusRepository storyStatusRepo;
	@Autowired private StoryPointRepository storyPointRepo;
	@Autowired private DeveloperService developerService;
	
	/**
	 * StoryService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 5:21:07 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Story> listAll()
	{
		return this.storyRepo.findAll();
	}

	/**
	 * StoryService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 5:21:10 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Story> listUnassigned()
	{
		return this.storyRepo.findUnassigned();
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStory
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 5:25:30 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Story create(Story argStory)
	{
		this.setStatus(argStory);
		this.setPoint(argStory);
		
		argStory.setIssueId(null);
		argStory.setCreationDate(Calendar.getInstance().getTime());
		
		Story newStory = this.storyRepo.saveAndFlush(argStory);
		if(argStory.getDeveloper() != null && argStory.getDeveloper().getId() != null) {
			Developer developer = this.developerService.findBy(argStory.getDeveloper().getId());
			newStory.setDeveloper(developer);
		}
		
		return newStory;
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStory
	 * 
	 * <b>created at</b> Mar 12, 2016 12:36:13 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void setDeveloper(Story argStory)
	{
		if(argStory.getDeveloper() != null && argStory.getDeveloper().getId() != null) {
			Developer developer = this.developerService.findBy(argStory.getDeveloper().getId());
			argStory.setDeveloper(developer);
		}
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStory
	 * 
	 * <b>created at</b> Mar 12, 2016 12:34:38 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void setPoint(Story argStory)
	{
		if(argStory.getStatus().getId() == 2 && argStory.getPoint() != null) {
			StoryPoint point = this.storyPointRepo.findOne(argStory.getPoint().getId());
			if(point == null) {
				throw new IllegalArgumentException("Choose correct point!");
			}
			argStory.setPoint(point);	
		}
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStory
	 * 
	 * <b>created at</b> Mar 12, 2016 12:33:40 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void setStatus(Story argStory)
	{
		if(argStory.getStatus() == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		
		StoryStatus status = this.storyStatusRepo.findOne(argStory.getStatus().getId());
		if(status == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		argStory.setStatus(status);
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStoryId
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 5:25:52 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Story findBy(Integer argStoryId)
	{
		return this.storyRepo.findOne(argStoryId);
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStoryId
	 * 
	 * <b>created at</b> Mar 6, 2016 5:26:10 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void deleteBy(Integer argStoryId)
	{
		// TODO: later!
//		this.storyRepo.delete(argStoryId);
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStoryId
	 * @param argStory
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 5:26:38 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Story update(Integer argStoryId, Story argStory)
	{
		Story story = this.storyRepo.findOne(argStoryId);
		if(story == null) {
			throw new IllegalArgumentException("Choose correct story!");			
		}
		
		story.setIssueId(argStoryId);
		story.setStatus(argStory.getStatus());
		story.setDeveloper(argStory.getDeveloper());
		if(argStory.getPoint() != null && argStory.getPoint().getId() != null) {
			story.setPoint(argStory.getPoint());	
		}
		story.setDescription(argStory.getDescription());
		story.setTitle(argStory.getTitle());
		
		
		this.setStatus(story);
		this.setDeveloper(story);
		this.setPoint(story);
		
		return this.storyRepo.saveAndFlush(story);
	}

	/**
	 * StoryService<br />
	 *
	 * @param argStoryIdList
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 6, 2016 5:40:19 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void assign(List<Integer> argStoryIdList, Integer argDeveloperId)
	{
		Developer developer = this.developerService.findBy(argDeveloperId);
		if(developer == null) {
			throw new IllegalArgumentException("Choose correct developer!");			
		}
		
		List<Story> storyListToAssign = new ArrayList<>();
		argStoryIdList.stream().forEach(itemId -> {
			Story story = this.findBy(itemId);
			if(story == null) {
				throw new IllegalArgumentException("Choose correct stories!");	
			}
			story.setDeveloper(developer);
			this.update(story.getIssueId(), story);
			storyListToAssign.add(story);
		});
		
		developer.setStories(storyListToAssign);
		this.developerService.update(argDeveloperId, developer);
	}
	
	/**
	 * StoryService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 11, 2016 11:49:31 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<StoryPoint> listPoint()
	{
		return this.storyPointRepo.findAll();
	}

	/**
	 * StoryService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 11, 2016 11:51:35 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<StoryStatus> listStatus()
	{
		return this.storyStatusRepo.findAll();
	}
	
	/**
	 * StoryService<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * <b>created at</b> Mar 16, 2016 1:35:06 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Story> getStoriesBy(Integer argDeveloperId)
	{
		return this.storyRepo.getStoriesBy(argDeveloperId);
	}

	/**
	 * StoryService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 16, 2016 10:20:47 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Sprint> listUnassignedSprintStories()
	{
		return this.storyRepo.findUnassignedSprintStories();
	}

	/**
	 * StoryService<br />
	 *
	 * @param argSprintId
	 * @return
	 *
	 * <b>created at</b> Mar 16, 2016 10:41:51 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Story> getDeveloperStoryListBy(Integer argSprintId)
	{
		return this.storyRepo.getDeveloperStoryListBy(argSprintId);
	}

	/**
	 * StoryService<br />
	 *
	 * @param argSprintId
	 * @return
	 *
	 * <b>created at</b> Mar 16, 2016 11:02:55 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Double getPointBy(Integer argSprintId)
	{
		return this.storyRepo.getPointBy(argSprintId);
	}
}
