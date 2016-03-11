package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Story;
import org.tokmak.pinguin.model.StoryPoint;
import org.tokmak.pinguin.model.StoryStatus;
import org.tokmak.pinguin.service.StoryService;

/**
 * <b>Project issue-tracker</b><br />
 * StoryController.java<br />
 *
 * <b>created at</b> Mar 3, 2016 2:43:20 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@RestController
@RequestMapping("/story")
public class StoryController
{
	@Autowired private StoryService storyService;
	
	/**
	 * StoryController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:22 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Story> listAllStories()
	{
		return this.storyService.listAll();
	}
	
	/**
	 * StoryController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:25 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/unassigned/list", method = RequestMethod.GET)
	public List<Story> listUnassignedStories()
	{
		return this.storyService.listUnassigned();
	}

	/**
	 * StoryController<br />
	 *
	 * @param argStory
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:28 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Story createStory(@RequestBody Story argStory)
	{
		return this.storyService.create(argStory);
	}

	/**
	 * StoryController<br />
	 *
	 * @param argStoryId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:30 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Story storyInformation(@PathVariable(value = "id") Integer argStoryId)
	{
		return this.storyService.findBy(argStoryId);
	}

	/**
	 * StoryController<br />
	 *
	 * @param argStoryId
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:33 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStory(@PathVariable(value = "id") Integer argStoryId)
	{
		this.storyService.deleteBy(argStoryId);
	}

	/**
	 * StoryController<br />
	 *
	 * @param argStory
	 * @param argStoryId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:36 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Story updateStory(@RequestBody Story argStory, @PathVariable(value = "id") Integer argStoryId)
	{
		return this.storyService.update(argStoryId, argStory);
	}
	
	/**
	 * StoryController<br />
	 *
	 * @param argStoryId
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 6, 2016 5:39:12 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/assign/{storyIds}/developer/{developerId}", method = RequestMethod.POST)
	public void assignToDeveloper(@PathVariable(value = "storyIds") List<Integer> argStoryIds, 
								  @PathVariable(value = "developerId") Integer argDeveloperId) 
	{
		this.storyService.assign(argStoryIds, argDeveloperId);
	}
	
	/**
	 * StoryController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 11, 2016 11:49:04 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/point/list", method = RequestMethod.GET)
	public List<StoryPoint> listAllStoryPoint()
	{
		return this.storyService.listPoint();
	}
	
	/**
	 * StoryController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 11, 2016 11:51:21 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/status/list", method = RequestMethod.GET)
	public List<StoryStatus> listAllStoryStatus()
	{
		return this.storyService.listStatus();
	}
}
