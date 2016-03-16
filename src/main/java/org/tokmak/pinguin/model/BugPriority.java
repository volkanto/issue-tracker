package org.tokmak.pinguin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Project issue-tracker</b><br />
 * BugPriority.java<br />
 *
 * <b>created at</b> Mar 2, 2016 10:56:01 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
@Table(name="BUG_PRIORITY")
public class BugPriority
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BUGPRIORITYID")
	private Integer id;
	
	@Column(name="DESCRIPTION")
	private String description;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 2, 2016 11:05:20 PM
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
	 * <b>created at</b> Mar 2, 2016 11:05:20 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}

	/**
	 * getDescription<br />
	 * @return the description
	 *
	 * <b>created at</b> Mar 2, 2016 11:05:20 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * setDescription<br />
	 *
	 * @param argDescription the description to set
	 *
	 * <b>created at</b> Mar 2, 2016 11:05:20 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDescription(String argDescription)
	{
		this.description = argDescription;
	}
}
