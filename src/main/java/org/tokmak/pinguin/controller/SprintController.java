package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Sprint;

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
		return null;
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
	public Sprint createSpring(@RequestBody Sprint argSprint)
	{
		argSprint.setId(null);
		return null;
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
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Sprint sprintInformation(@PathVariable(value = "id") Integer argSprintId)
	{
		return null;
	}

	/**
	 * SprintController<br />
	 *
	 * @param argSprintId
	 * 
	 * <b>created at</b> Mar 5, 2016 4:17:14 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSprint(@PathVariable(value = "id") Integer argSprintId)
	{
		
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
		argSprint.setId(argSprintId);
		return null;
	}
}
