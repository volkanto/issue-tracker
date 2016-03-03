package org.tokmak.pinguin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperBug.java<br />
 *
 * <b>created at</b> Mar 3, 2016 2:35:49 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class DeveloperBug
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Developer developer;
	
	@OneToOne
	private Bug bug;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDeveloper(Developer argDeveloper)
	{
		this.developer = argDeveloper;
	}

	/**
	 * getBug<br />
	 * @return the bug
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Bug getBug()
	{
		return this.bug;
	}

	/**
	 * setBug<br />
	 *
	 * @param argBug the bug to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:47 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setBug(Bug argBug)
	{
		this.bug = argBug;
	}

}
