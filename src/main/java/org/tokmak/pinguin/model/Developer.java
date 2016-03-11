package org.tokmak.pinguin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="DEVELOPER")
public class Developer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEVELOPERID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ACTIVE")
	private boolean active = true;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "DEVELOPER_BUG", joinColumns = { @JoinColumn(name = "DEVELOPERID") }, inverseJoinColumns = { @JoinColumn(name = "ISSUEID") })
	private Set<Bug> bugs = new HashSet<Bug>(0);
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "DEVELOPER_STORY", joinColumns = { @JoinColumn(name = "DEVELOPERID") }, inverseJoinColumns = { @JoinColumn(name = "ISSUEID") })
	private Set<Story> stories = new HashSet<Story>(0);
	
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
	/**
	 * getBugs<br />
	 * @return the bugs
	 *
	 * <b>created at</b> Mar 6, 2016 5:47:54 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Set<Bug> getBugs()
	{
		return this.bugs;
	}
	/**
	 * setBugs<br />
	 *
	 * @param argBugs the bugs to set
	 *
	 * <b>created at</b> Mar 6, 2016 5:47:54 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setBugs(Set<Bug> argBugs)
	{
		this.bugs = argBugs;
	}
	/**
	 * getStories<br />
	 * @return the stories
	 *
	 * <b>created at</b> Mar 6, 2016 5:47:54 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Set<Story> getStories()
	{
		return this.stories;
	}
	/**
	 * setStories<br />
	 *
	 * @param argStories the stories to set
	 *
	 * <b>created at</b> Mar 6, 2016 5:47:54 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStories(Set<Story> argStories)
	{
		this.stories = argStories;
	}
}
