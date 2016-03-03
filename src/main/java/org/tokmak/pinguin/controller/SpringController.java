package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Sprint;

@RestController
@RequestMapping("/sprint")
public class SpringController
{
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Sprint> listAllSprints()
	{
		return null;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Sprint createSpring(@RequestBody Sprint argSprint)
	{
		argSprint.setId(null);
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Sprint sprintInformation(@PathVariable(value = "id") Integer argSprintId)
	{
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSprint(@PathVariable(value = "id") Integer argSprintId)
	{
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Sprint updateSprint(@RequestBody Sprint argSprint, @PathVariable(value = "id") Integer argSprintId)
	{
		argSprint.setId(argSprintId);
		return null;
	}
}
