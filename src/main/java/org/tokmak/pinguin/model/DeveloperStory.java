package org.tokmak.pinguin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperStory.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:12:54 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class DeveloperStory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Developer developer;
	
	@OneToOne
	private Story story;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}

	/**
	 * getDeveloper<br />
	 * @return the developer
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Developer getDeveloper()
	{
		return this.developer;
	}

	/**
	 * setDeveloper<br />
	 *
	 * @param argDeveloper the developer to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDeveloper(Developer argDeveloper)
	{
		this.developer = argDeveloper;
	}

	/**
	 * getStory<br />
	 * @return the story
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:59 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStory(Story argStory)
	{
		this.story = argStory;
	}
}
