package org.tokmak.pinguin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <b>Project issue-tracker</b><br />
 * Developer.java<br />
 *
 * <b>created at</b> Feb 28, 2016 2:21:58 AM
 * 
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class Developer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private boolean active;
	
	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
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
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}
	/**
	 * getName<br />
	 * @return the name
	 *
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * setName<br />
	 *
	 * @param argName the name to set
	 *
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setName(String argName)
	{
		this.name = argName;
	}
	/**
	 * isActive<br />
	 * @return the active
	 *
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public boolean isActive()
	{
		return this.active;
	}
	/**
	 * setActive<br />
	 *
	 * @param argActive the active to set
	 *
	 * <b>created at</b> Feb 28, 2016 2:28:21 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setActive(boolean argActive)
	{
		this.active = argActive;
	}
}
