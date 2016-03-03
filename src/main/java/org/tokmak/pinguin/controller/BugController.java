package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Bug;
import org.tokmak.pinguin.repository.BugRepository;

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
	@Autowired
	private BugRepository bugRepo;

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
		return this.bugRepo.findAll();
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
		argBug.setIssueId(null);
		return this.bugRepo.saveAndFlush(argBug);
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
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Bug bugInformation(@PathVariable(value = "id") Integer argBugId)
	{
		return this.bugRepo.findOne(argBugId);
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
		this.bugRepo.delete(argBugId);
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
		argBug.setIssueId(argBugId);
		return this.bugRepo.saveAndFlush(argBug);
	}
}
