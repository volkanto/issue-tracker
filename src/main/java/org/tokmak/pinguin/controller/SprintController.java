package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Sprint;
import org.tokmak.pinguin.service.SprintService;
import org.tokmak.pinguin.service.StoryService;

/**
 * <b>Project issue-tracker</b><br />
 * SprintController.java<br />
 *
 * <b>created at</b> Mar 5, 2016 4:17:04 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@RestController
@RequestMapping("/sprint")
public class SprintController
{
	@Autowired private SprintService sprintService; 
	@Autowired private StoryService storyService;
	
	/**
	 * SprintController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:06 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Sprint> listAllSprints()
	{
		return this.sprintService.listAll();
	}
	
	/**
	 * SprintController<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 16, 2016 10:20:09 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/unassigned/story/list", method = RequestMethod.GET)
	public List<Sprint> listUnassignedStoryList()
	{
		return this.storyService.listUnassignedSprintStories();
	}
	
	/**
	 * SprintController<br />
	 *
	 * @param argSprint
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:09 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Sprint createSprint(@RequestBody Sprint argSprint)
	{
		return this.sprintService.create(argSprint);
	}

	/**
	 * SprintController<br />
	 *
	 * @param argSprintId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:12 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sprint sprintInformation(@PathVariable(value = "id") Integer argSprintId)
	{
		return this.sprintService.getInformation(argSprintId);
	}

	/**
	 * SprintController<br />
	 *
	 * @param argSprint
	 * @param argSprintId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:17 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Sprint updateSprint(@RequestBody Sprint argSprint, @PathVariable(value = "id") Integer argSprintId)
	{
		return this.sprintService.update(argSprintId, argSprint);
	}
	
	/**
	 * SprintController<br />
	 *
	 * @param argStoryIds
	 * @param argSprintId
	 * 
	 * <b>created at</b> Mar 13, 2016 1:36:24 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{sprintId}/assign/story/{storyId}", method = RequestMethod.POST)
	public void assignToSprint(@PathVariable(value = "storyId") Integer argStoryId, 
							   @PathVariable(value = "sprintId") Integer argSprintId) 
	{
		this.sprintService.assign(argSprintId, argStoryId);
	}
}
