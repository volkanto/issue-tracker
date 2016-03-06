package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Bug;
import org.tokmak.pinguin.model.BugPriority;
import org.tokmak.pinguin.model.BugStatus;
import org.tokmak.pinguin.service.BugService;

/**
 * <b>Project issue-tracker</b><br />
 * BugController.java<br />
 *
 * <b>created at</b> Mar 1, 2016 11:21:50 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@RestController
@RequestMapping("/bug")
public class BugController
{
	@Autowired private BugService bugService;
	
	/**
	 * BugController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 1, 2016 11:25:55 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Bug> listAllBugs()
	{
		return this.bugService.listAll();
	}
	
	/**
	 * BugController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 6, 2016 1:24:56 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/unassigned/list", method = RequestMethod.GET)
	public List<Bug> listUnassignedBugs()
	{
		return this.bugService.listUnassigned();
	}

	/**
	 * BugController<br />
	 *
	 * @param argBug
	 * @return
	 * 
	 * <b>created at</b> Mar 1, 2016 11:25:58 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Bug createBug(@RequestBody Bug argBug)
	{
		return this.bugService.create(argBug);
	}

	/**
	 * BugController<br />
	 *
	 * @param argBugId
	 * @return
	 * 
	 * <b>created at</b> Mar 1, 2016 11:26:00 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Bug bugInformation(@PathVariable(value = "id") Integer argBugId)
	{
		return this.bugService.findBy(argBugId);
	}

	/**
	 * BugController<br />
	 *
	 * @param argBugId
	 * 
	 * <b>created at</b> Mar 1, 2016 11:26:03 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteBug(@PathVariable(value = "id") Integer argBugId)
	{
		this.bugService.deleteBy(argBugId);
	}

	/**
	 * BugController<br />
	 *
	 * @param argBug
	 * @param argBugId
	 * @return
	 * 
	 * <b>created at</b> Mar 1, 2016 11:26:06 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Bug updateBug(@RequestBody Bug argBug, @PathVariable(value = "id") Integer argBugId)
	{
		return this.bugService.update(argBugId, argBug);
	}
	
	/**
	 * BugController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 3, 2016 9:45:26 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/status/list", method = RequestMethod.GET)
	public List<BugStatus> listAllBugStatus()
	{
		return this.bugService.listStatus();
	}
	
	/**
	 * BugController<br />
	 *
	 * @param argBugStatus
	 * @return
	 * 
	 * <b>created at</b> Mar 3, 2016 9:51:03 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/status/create", method = RequestMethod.POST)
	public BugStatus createBugStatus(@RequestBody BugStatus argBugStatus)
	{
		return this.bugService.createStatus(argBugStatus);
	}
	
	/**
	 * BugController<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 3, 2016 11:51:25 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/priority/list", method = RequestMethod.GET)
	public List<BugPriority> listAllBugPriority()
	{
		return this.bugService.listPriority();
	}
	
	/**
	 * BugController<br />
	 *
	 * @param argBugPriority
	 * @return
	 * 
	 * <b>created at</b> Mar 3, 2016 11:51:27 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/priority/create", method = RequestMethod.POST)
	public BugPriority createBugPriority(@RequestBody BugPriority argBugPriority)
	{
		return this.bugService.createPriority(argBugPriority);
	}
	
	/**
	 * BugController<br />
	 *
	 * @param argBugIds
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 6, 2016 5:49:35 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/assign/{bugIds}/developer/{developerId}", method = RequestMethod.POST)
	public void assignToDeveloper(@PathVariable(value = "bugIds") List<Integer> argBugIds, 
								  @PathVariable(value = "developerId") Integer argDeveloperId) 
	{
		this.bugService.assign(argBugIds, argDeveloperId);
	}
}
