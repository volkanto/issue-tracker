package org.tokmak.pinguin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Bug;
import org.tokmak.pinguin.model.Developer;
import org.tokmak.pinguin.model.Story;
import org.tokmak.pinguin.repository.DeveloperRepository;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperService.java<br />
 *
 * <b>created at</b> Mar 5, 2016 10:52:21 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Service
@Transactional
public class DeveloperService
{
	@Autowired private DeveloperRepository developerRepo;
	@Autowired private BugService bugService;
	@Autowired private StoryService storyService;

	/**
	 * DeveloperService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 10:53:07 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Developer> findAll()
	{
		return this.developerRepo.findAll();
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloper
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 10:53:35 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Developer create(Developer argDeveloper)
	{
		if(developerExist(argDeveloper)) {
			throw new RuntimeException("Developer Exists"); 
		}
		
		argDeveloper.setId(null);
		argDeveloper.setActive(true);
		return this.developerRepo.saveAndFlush(argDeveloper);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloper
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 11:01:42 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private boolean developerExist(Developer argDeveloper)
	{
		return this.developerRepo.findByName(argDeveloper.getName()) != null ? true : false;
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 11:02:31 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Developer findBy(Integer argDeveloperId)
	{
		if(argDeveloperId == null) {
			throw new RuntimeException("Choose correct developer!");
		}
		return this.developerRepo.findOne(argDeveloperId);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 5, 2016 11:02:52 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public void delete(Integer argDeveloperId)
	{
		Developer developer = checkAndReturnDeveloper(argDeveloperId);
		developer.setActive(false);
		this.unassignBugs(developer);
		this.unassignStories(developer);
		
		this.developerRepo.saveAndFlush(developer);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloper
	 * 
	 * <b>created at</b> Mar 16, 2016 1:33:26 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void unassignStories(Developer argDeveloper)
	{
		List<Story> developerStories = this.getStoriesBy(argDeveloper.getId());
		developerStories.stream().forEach(story -> {
			story.setDeveloper(null);
			this.storyService.update(story.getIssueId(), story);
		});
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * <b>created at</b> Mar 16, 2016 1:34:37 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private List<Story> getStoriesBy(Integer argDeveloperId)
	{
		return this.storyService.getStoriesBy(argDeveloperId);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloper
	 * 
	 * <b>created at</b> Mar 16, 2016 1:23:58 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void unassignBugs(Developer argDeveloper)
	{
		List<Bug> developerBugs = this.getBugsBy(argDeveloper.getId());
		developerBugs.stream().forEach(bug -> {
			bug.setDeveloper(null);
			this.bugService.update(bug.getIssueId(), bug);
		});
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * <b>created at</b> Mar 16, 2016 1:27:07 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private List<Bug> getBugsBy(Integer argDeveloperId)
	{
		return this.bugService.getBugsBy(argDeveloperId);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * @param argDeveloper
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 11:04:48 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 *  
	 */
	public Developer update(Integer argDeveloperId, Developer argDeveloper)
	{
		checkDeveloper(argDeveloperId);
		
		argDeveloper.setId(argDeveloperId);
		return this.developerRepo.saveAndFlush(argDeveloper);
	}

	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * 
	 * <b>created at</b> Mar 5, 2016 11:06:26 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private void checkDeveloper(Integer argDeveloperId)
	{
		Developer developer = this.developerRepo.findOne(argDeveloperId);
		if(developer == null) {
			throw new RuntimeException("Developer not exists");
		}
	}
	
	/**
	 * DeveloperService<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 11:07:44 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	private Developer checkAndReturnDeveloper(Integer argDeveloperId)
	{
		Developer developer = this.developerRepo.findOne(argDeveloperId);
		if(developer == null) {
			throw new RuntimeException("Developer not exists");
		}
		return developer;
	}

	/**
	 * DeveloperService<br />
	 *
	 * @return
	 *
	 * <b>created at</b> Mar 16, 2016 10:56:53 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Integer count()
	{
		return this.developerRepo.findAll().size();
	}
}
