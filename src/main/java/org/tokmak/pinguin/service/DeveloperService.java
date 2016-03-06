package org.tokmak.pinguin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Developer;
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
public class DeveloperService
{
	@Autowired private DeveloperRepository developerRepository;

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
		return this.developerRepository.findAll();
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
			throw new RuntimeException(); // TODO
		}
		
		argDeveloper.setId(null);
		return this.developerRepository.saveAndFlush(argDeveloper);
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
		return this.developerRepository.findByName(argDeveloper.getName()) != null ? true : false;
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
	public Developer getInformation(Integer argDeveloperId)
	{
		return this.developerRepository.findOne(argDeveloperId);
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
		this.developerRepository.saveAndFlush(developer);
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
		return this.developerRepository.saveAndFlush(argDeveloper);
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
		Developer developer = this.developerRepository.findOne(argDeveloperId);
		if(developer == null) {
			throw new RuntimeException(); // TODO
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
		Developer developer = this.developerRepository.findOne(argDeveloperId);
		if(developer == null) {
			throw new RuntimeException(); // TODO
		}
		return developer;
	}
	
}
