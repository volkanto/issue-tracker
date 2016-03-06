package org.tokmak.pinguin.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Bug;
import org.tokmak.pinguin.model.BugPriority;
import org.tokmak.pinguin.model.BugStatus;
import org.tokmak.pinguin.repository.BugPriorityRepository;
import org.tokmak.pinguin.repository.BugRepository;
import org.tokmak.pinguin.repository.BugStatusRepository;

/**
 * <b>Project issue-tracker</b><br />
 * BugService.java<br />
 *
 * <b>created at</b> Mar 6, 2016 2:14:17 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Service
@Transactional
public class BugService
{
	@Autowired private BugRepository bugRepo;
	@Autowired private BugStatusRepository bugStatusRepo;
	@Autowired private BugPriorityRepository bugPriorityRepo;
	
	/**
	 * BugService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:29 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Bug> listAll()
	{
		return this.bugRepo.findAll();
	}

	/**
	 * BugService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:27 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Bug> listUnassigned()
	{
		return this.bugRepo.findUnassigned();
	}

	/**
	 * BugService<br />
	 *
	 * @param argBug
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:24 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Bug create(Bug argBug)
	{
		BugStatus status = this.bugStatusRepo.findOne(argBug.getStatus().getId());
		if(status == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		argBug.setStatus(status);
		
		BugPriority priority = this.bugPriorityRepo.findOne(argBug.getPriority().getId());
		if(priority == null) {
			throw new IllegalArgumentException("Choose correct priority!");
		}
		argBug.setPriority(priority);
		
		argBug.setIssueId(null);
		argBug.setCreationDate(Calendar.getInstance().getTime());
		return this.bugRepo.saveAndFlush(argBug);
	}

	/**
	 * BugService<br />
	 *
	 * @param argBugId
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:21 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Bug findBy(Integer argBugId)
	{
		return this.bugRepo.findOne(argBugId);
	}

	/**
	 * BugService<br />
	 *
	 * @param argBugId
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:17 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void deleteBy(Integer argBugId)
	{
		// TODO: later!
//		this.bugRepo.delete(argBugId);
	}

	/**
	 * BugService<br />
	 *
	 * @param argBugId
	 * @param argBug
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:14 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Bug update(Integer argBugId, Bug argBug)
	{
		Bug bug = this.bugRepo.findOne(argBugId);
		if(bug == null) {
			throw new IllegalArgumentException("Choose correct bug!");			
		}
		
		argBug.setIssueId(argBugId);
		return this.bugRepo.saveAndFlush(argBug);
	}

	/**
	 * BugService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:12 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<BugStatus> listStatus()
	{
		return this.bugStatusRepo.findAll();
	}

	/**
	 * BugService<br />
	 *
	 * @param argBugStatus
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:10 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public BugStatus createStatus(BugStatus argBugStatus)
	{
		argBugStatus.setId(null);
		return this.bugStatusRepo.saveAndFlush(argBugStatus);
	}

	/**
	 * BugService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:08 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<BugPriority> listPriority()
	{
		return this.bugPriorityRepo.findAll();
	}

	/**
	 * BugService<br />
	 *
	 * @param argBugPriority
	 * @return
	 *
	 * <b>created at</b> Mar 6, 2016 2:30:05 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public BugPriority createPriority(BugPriority argBugPriority)
	{
		argBugPriority.setId(null);
		return this.bugPriorityRepo.saveAndFlush(argBugPriority);
	}

}
