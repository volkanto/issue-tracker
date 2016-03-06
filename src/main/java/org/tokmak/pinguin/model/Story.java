package org.tokmak.pinguin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>Project issue-tracker</b><br />
 * Story.java<br />
 *
 * <b>created at</b> Mar 3, 2016 1:08:57 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
@Table(name="STORY")
public class Story
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ISSUEID")
	private Integer issueId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CREATIONDATE")
	private Date creationDate;
	
	@OneToOne
	private StoryPoint estimatedPoint;
	
	@OneToOne
	private StoryStatus status;

	/**
	 * getIssueId<br />
	 * @return the issueId
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Integer getIssueId()
	{
		return this.issueId;
	}

	/**
	 * setIssueId<br />
	 *
	 * @param argIssueId the issueId to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setIssueId(Integer argIssueId)
	{
		this.issueId = argIssueId;
	}

	/**
	 * getTitle<br />
	 * @return the title
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
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
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
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
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
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
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDescription(String argDescription)
	{
		this.description = argDescription;
	}

	/**
	 * getCreationDate<br />
	 * @return the creationDate
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Date getCreationDate()
	{
		return this.creationDate;
	}

	/**
	 * setCreationDate<br />
	 *
	 * @param argCreationDate the creationDate to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setCreationDate(Date argCreationDate)
	{
		this.creationDate = argCreationDate;
	}

	/**
	 * getEstimatedPoint<br />
	 * @return the estimatedPoint
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public StoryPoint getEstimatedPoint()
	{
		return this.estimatedPoint;
	}

	/**
	 * setEstimatedPoint<br />
	 *
	 * @param argEstimatedPoint the estimatedPoint to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setEstimatedPoint(StoryPoint argEstimatedPoint)
	{
		this.estimatedPoint = argEstimatedPoint;
	}

	/**
	 * getStatus<br />
	 * @return the status
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public StoryStatus getStatus()
	{
		return this.status;
	}

	/**
	 * setStatus<br />
	 *
	 * @param argStatus the status to set
	 *
	 * <b>created at</b> Mar 3, 2016 1:08:53 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStatus(StoryStatus argStatus)
	{
		this.status = argStatus;
	}
}
