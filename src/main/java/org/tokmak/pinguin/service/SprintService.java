package org.tokmak.pinguin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tokmak.pinguin.model.Sprint;
import org.tokmak.pinguin.repository.SprintRepository;

/**
 * <b>Project issue-tracker</b><br />
 * SprintService.java<br />
 *
 * <b>created at</b> Mar 5, 2016 7:22:33 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Service
public class SprintService
{
	@Autowired private SprintRepository sprintRepository;

	/**
	 * SprintService<br />
	 *
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 7:23:16 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public List<Sprint> listAll()
	{
		return this.sprintRepository.findAll();
	}

	/**
	 * SprintService<br />
	 *
	 * @param argSprint
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 7:35:43 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Sprint create(Sprint argSprint)
	{
		argSprint.setId(null);
		return this.sprintRepository.saveAndFlush(argSprint);
	}

	/**
	 * SprintService<br />
	 *
	 * @param argSprintId
	 * @return
	 * 
	 * <b>created at</b> Mar 5, 2016 8:05:59 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	public Sprint getInformation(Integer argSprintId)
	{
		return this.sprintRepository.getOne(argSprintId);
	}
}
