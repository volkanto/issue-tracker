package org.tokmak.pinguin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * <b>Project issue-tracker</b><br />
 * SprintStory.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:19:22 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class SprintStory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Sprint sprint;
	
	@OneToOne
	private Story story;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Integer getId()
	{
		return this.id;
	}

	/**
	 * setId<br />
	 *
	 * @param argId the id to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}

	/**
	 * getSprint<br />
	 * @return the sprint
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Sprint getSprint()
	{
		return this.sprint;
	}

	/**
	 * setSprint<br />
	 *
	 * @param argSprint the sprint to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setSprint(Sprint argSprint)
	{
		this.sprint = argSprint;
	}

	/**
	 * getStory<br />
	 * @return the story
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Story getStory()
	{
		return this.story;
	}

	/**
	 * setStory<br />
	 *
	 * @param argStory the story to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:36:15 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStory(Story argStory)
	{
		this.story = argStory;
	}
}
