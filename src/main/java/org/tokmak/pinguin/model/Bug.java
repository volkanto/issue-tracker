package org.tokmak.pinguin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * <b>Project issue-tracker</b><br />
 * Bug.java<br />
 *
 * <b>created at</b> Mar 1, 2016 11:25:19 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
@Entity
@Table(name="BUG")
public class Bug
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
	@JoinColumn(name="BUGSTATUSID")
	private BugStatus status;
	
	@OneToOne
	@JoinColumn(name="BUGPRIORITYID")
	private BugPriority priority;
	
	@ManyToOne
	@JoinColumn(name="DEVELOPERID")
	@JsonBackReference(value="developer-bugs")
	private Developer developer;
	
	/**
	 * getIssueId<br />
	 * @return the issueId
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
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
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
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
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
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
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setTitle(String argTitle)
	{
		this.title = argTitle;
	}
	/**
	 * getCreationDate<br />
	 * @return the creationDate
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
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
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setCreationDate(Date argCreationDate)
	{
		this.creationDate = argCreationDate;
	}
	/**
	 * getStatus<br />
	 * @return the status
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public BugStatus getStatus()
	{
		return this.status;
	}
	/**
	 * setStatus<br />
	 *
	 * @param argStatus the status to set
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStatus(BugStatus argStatus)
	{
		this.status = argStatus;
	}
	/**
	 * getPriority<br />
	 * @return the priority
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public BugPriority getPriority()
	{
		return this.priority;
	}
	/**
	 * setPriority<br />
	 *
	 * @param argPriority the priority to set
	 *
	 * <b>created at</b> Mar 1, 2016 11:25:14 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setPriority(BugPriority argPriority)
	{
		this.priority = argPriority;
	}
	/**
	 * getDescription<br />
	 * @return the description
	 *
	 * <b>created at</b> Mar 3, 2016 1:07:01 PM
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
	 * <b>created at</b> Mar 3, 2016 1:07:01 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDescription(String argDescription)
	{
		this.description = argDescription;
	}
	/**
	 * getDeveloper<br />
	 * @return the developer
	 *
	 * <b>created at</b> Mar 10, 2016 12:18:13 AM
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
	 * <b>created at</b> Mar 10, 2016 12:18:13 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDeveloper(Developer argDeveloper)
	{
		this.developer = argDeveloper;
	}
}
