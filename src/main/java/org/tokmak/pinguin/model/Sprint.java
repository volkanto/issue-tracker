package org.tokmak.pinguin.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * <b>Project issue-tracker</b><br />
 * Sprint.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:13:49 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
@Table(name="SPRINT")
public class Sprint
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SPRINTID")
	private Integer id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STARTDATE")
	private Date startDate;
	
	@Column(name="ENDDATE")
	private Date endDate;
	
	@OneToMany(targetEntity=Story.class, mappedBy="sprint", fetch=FetchType.LAZY)
	@JsonManagedReference(value="sprint-stories")
	private List<Story> stories;

	/**
	 * getId<br />
	 * @return the id
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
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
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setId(Integer argId)
	{
		this.id = argId;
	}

	/**
	 * getTitle<br />
	 * @return the title
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * setTitle<br />
	 *
	 * @param argTitle the title to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setTitle(String argTitle)
	{
		this.title = argTitle;
	}

	/**
	 * getDescription<br />
	 * @return the description
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
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
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDescription(String argDescription)
	{
		this.description = argDescription;
	}

	/**
	 * getStartDate<br />
	 * @return the startDate
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Date getStartDate()
	{
		return this.startDate;
	}

	/**
	 * setStartDate<br />
	 *
	 * @param argStartDate the startDate to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStartDate(Date argStartDate)
	{
		this.startDate = argStartDate;
	}

	/**
	 * getEndDate<br />
	 * @return the endDate
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Date getEndDate()
	{
		return this.endDate;
	}

	/**
	 * setEndDate<br />
	 *
	 * @param argEndDate the endDate to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:13:57 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setEndDate(Date argEndDate)
	{
		this.endDate = argEndDate;
	}

	/**
	 * getStories<br />
	 * @return the stories
	 *
	 * <b>created at</b> Mar 15, 2016 11:48:42 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public List<Story> getStories()
	{
		return this.stories;
	}

	/**
	 * setStories<br />
	 *
	 * @param argStories the stories to set
	 *
	 * <b>created at</b> Mar 15, 2016 11:48:42 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStories(List<Story> argStories)
	{
		this.stories = argStories;
	}
}
