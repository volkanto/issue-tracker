package org.tokmak.pinguin.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		StoryStatus status = this.storyStatusRepo.findOne(argStory.getStatus().getId());
		if(status == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		argStory.setStatus(status);
		
		StoryPoint point = this.storyPointRepo.findOne(argStory.getPoint().getId());
		if(point == null) {
			throw new IllegalArgumentException("Choose correct point!");
		}
		argStory.setPoint(point);
		
		argStory.setIssueId(null);
		argStory.setCreationDate(Calendar.getInstance().getTime());
		return this.storyRepo.saveAndFlush(argStory);
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
		
		argStory.setIssueId(argStoryId);
		return this.storyRepo.saveAndFlush(argStory);
	}

}
