package org.tokmak.pinguin.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Bug;
import org.tokmak.pinguin.model.BugPriority;
import org.tokmak.pinguin.model.BugStatus;
import org.tokmak.pinguin.model.Developer;
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
	@Autowired private DeveloperService developerService;
	
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
		this.setStatus(argBug);
		this.setPriority(argBug);
		
		argBug.setIssueId(null);
		argBug.setCreationDate(Calendar.getInstance().getTime());
		
		if(argBug.getDeveloper() != null && argBug.getDeveloper().getId() != null) {
			Developer developer = this.developerService.findBy(argBug.getDeveloper().getId());
			argBug.setDeveloper(developer);
		}
//		Bug bug = this.bugRepo.saveAndFlush(argBug);
		
//		this.assignToDeveloper(argBug.getDeveloper(), bug);
		
//		return bug;
		return this.bugRepo.saveAndFlush(argBug);
	}

	/**
	 * BugService<br />
	 *
	 * @param argDeveloper
	 * @param argBug
	 * 
	 * <b>created at</b> Mar 10, 2016 12:56:11 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void assignToDeveloper(Developer argDeveloper, Bug argBug)
	{
		if(argDeveloper != null) {
			this.assign(Arrays.asList(argBug.getIssueId()), argDeveloper.getId());			
		}
	}

	/**
	 * BugService<br />
	 *
	 * @param argBug
	 * 
	 * <b>created at</b> Mar 10, 2016 12:52:12 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void setStatus(Bug argBug)
	{
		if(argBug.getStatus() == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		
		BugStatus status = this.bugStatusRepo.findOne(argBug.getStatus().getId());
		if(status == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		argBug.setStatus(status);
	}

	/**
	 * BugService<br />
	 *
	 * @param argBug
	 * 
	 * <b>created at</b> Mar 10, 2016 12:52:14 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void setPriority(Bug argBug)
	{
		if(argBug.getPriority() == null) {
			throw new IllegalArgumentException("Choose correct priority!");
		}
		
		BugPriority priority = this.bugPriorityRepo.findOne(argBug.getPriority().getId());
		if(priority == null) {
			throw new IllegalArgumentException("Choose correct priority!");
		}
		argBug.setPriority(priority);
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
		
		BugStatus status = this.bugStatusRepo.findOne(argBug.getStatus().getId());
		if(status == null) {
			throw new IllegalArgumentException("Choose correct status!");
		}
		
		BugPriority priority = this.bugPriorityRepo.findOne(argBug.getPriority().getId());
		if(priority == null) {
			throw new IllegalArgumentException("Choose correct priority!");
		}
		
		bug.setStatus(status);
		bug.setPriority(priority);
		bug.setIssueId(argBugId);
		
		return this.bugRepo.saveAndFlush(bug);
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

	/**
	 * BugService<br />
	 *
	 * @param argBugIdList
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 6, 2016 5:49:44 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void assign(List<Integer> argBugIdList, Integer argDeveloperId)
	{
		Developer developer = this.developerService.findBy(argDeveloperId);
		if(developer == null) {
			throw new IllegalArgumentException("Choose correct developer!");			
		}
		
		Set<Bug> bugListToAssign = new HashSet<>();
		argBugIdList.stream().forEach(itemId -> {
			Bug bug = this.findBy(itemId);
			if(bug == null) {
				throw new IllegalArgumentException("Choose correct bugs!");	
			}
			
			bugListToAssign.add(bug);
		});
		
		developer.setBugs(bugListToAssign);
	}
}
