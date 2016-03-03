package org.tokmak.pinguin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * <b>Project issue-tracker</b><br />
 * SprintDeveloperPoint.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:28:36 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
public class SprintDeveloperPoint
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Sprint sprint;
	
	@ManyToOne
	private Developer developer;
	
	@Column
	private Double totalPoint;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setSprint(Sprint argSprint)
	{
		this.sprint = argSprint;
	}

	/**
	 * getDeveloper<br />
	 * @return the developer
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
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
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDeveloper(Developer argDeveloper)
	{
		this.developer = argDeveloper;
	}

	/**
	 * getTotalPoint<br />
	 * @return the totalPoint
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Double getTotalPoint()
	{
		return this.totalPoint;
	}

	/**
	 * setTotalPoint<br />
	 *
	 * @param argTotalPoint the totalPoint to set
	 *
	 * <b>created at</b> Mar 3, 2016 2:35:06 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setTotalPoint(Double argTotalPoint)
	{
		this.totalPoint = argTotalPoint;
	}
	
}
