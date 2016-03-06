package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Developer;
import org.tokmak.pinguin.service.DeveloperService;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperController.java<br />
 *
 * <b>created at</b> Feb 28, 2016 2:22:02 AM
 * 
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@RestController
@RequestMapping("/developer")
public class DeveloperController
{
	@Autowired
	private DeveloperService developerService;

	/**
	 * DeveloperController<br />
	 *
	 * @return
	 * 
	 * 		<b>created at</b> Feb 28, 2016 2:22:05 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Developer> listAllDevelopers()
	{
		return this.developerService.findAll();
	}

	/**
	 * DeveloperController<br />
	 *
	 * @param argDeveloper
	 * @return
	 * 
	 * 		<b>created at</b> Feb 28, 2016 2:22:08 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Developer createDeveloper(@RequestBody Developer argDeveloper)
	{
		return this.developerService.create(argDeveloper);
	}

	/**
	 * DeveloperController<br />
	 *
	 * @param argDeveloperId
	 * @return
	 * 
	 * 		<b>created at</b> Feb 28, 2016 2:24:06 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Developer developerInformation(@PathVariable(value = "id") Integer argDeveloperId)
	{
		return this.developerService.getInformation(argDeveloperId);
	}

	/**
	 * DeveloperController<br />
	 *
	 * @param argDeveloperId
	 * 
	 *            <b>created at</b> Feb 28, 2016 2:24:45 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeveloper(@PathVariable(value = "id") Integer argDeveloperId)
	{
		this.developerService.delete(argDeveloperId);
	}

	/**
	 * DeveloperController<br />
	 *
	 * @param argDeveloper
	 * @param argDeveloperId
	 * 
	 *            <b>created at</b> Feb 28, 2016 2:25:16 AM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Developer updateDeveloper(@RequestBody Developer argDeveloper,
									 @PathVariable(value = "id") Integer argDeveloperId)
	{
		return this.developerService.update(argDeveloperId, argDeveloper);
	}
}
