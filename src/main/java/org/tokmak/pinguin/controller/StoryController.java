package org.tokmak.pinguin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tokmak.pinguin.model.Story;

/**
 * <b>Project issue-tracker</b><br />
 * StoryController.java<br />
 *
 * <b>created at</b> Mar 3, 2016 2:43:20 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@RestController
@RequestMapping("/story")
public class StoryController
{
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Story> listAllStories()
	{
		return null;
	}
	
	@RequestMapping(value = "/unassigned/list", method = RequestMethod.GET)
	public List<Story> listUnassignedStories()
	{
		return null;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Story createStory(@RequestBody Story argStory)
	{
		argStory.setIssueId(null);
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Story storyInformation(@PathVariable(value = "id") Integer argStoryId)
	{
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStory(@PathVariable(value = "id") Integer argStoryId)
	{
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Story updateStory(@RequestBody Story argStory, @PathVariable(value = "id") Integer argStoryId)
	{
		argStory.setIssueId(argStoryId);
		return null;
	}
}
