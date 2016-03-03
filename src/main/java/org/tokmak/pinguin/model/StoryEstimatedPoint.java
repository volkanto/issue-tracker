package org.tokmak.pinguin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <b>Project issue-tracker</b><br />
 * EstimatedPoint.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:09:50 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class StoryEstimatedPoint
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Double value;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 1:09:49 PM
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
	 * <b>created at</b> Mar 3, 2016 1:09:49 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}

	/**
	 * getValue<br />
	 * @return the value
	 *
	 * <b>created at</b> Mar 3, 2016 1:09:49 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Double getValue()
	{
		return this.value;
	}

	/**
	 * setValue<br />
	 *
	 * @param argValue the value to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:09:49 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setValue(Double argValue)
	{
		this.value = argValue;
	}
}
