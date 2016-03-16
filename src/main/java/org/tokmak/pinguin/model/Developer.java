package org.tokmak.pinguin.model;

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
	
	@OneToMany(targetEntity=Bug.class, mappedBy="developer", fetch=FetchType.LAZY)
	@JsonManagedReference(value="developer-bugs")
	private List<Bug> bugs;
	
	@OneToMany(targetEntity=Story.class, mappedBy="developer", fetch=FetchType.LAZY)
	@JsonManagedReference(value="developer-stories")
	private List<Story> stories;
	
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
	 * <b>created at</b> Mar 15, 2016 10:01:45 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public List<Bug> getBugs()
	{
		return this.bugs;
	}
	/**
	 * setBugs<br />
	 *
	 * @param argBugs the bugs to set
	 *
	 * <b>created at</b> Mar 15, 2016 10:01:45 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setBugs(List<Bug> argBugs)
	{
		this.bugs = argBugs;
	}
	/**
	 * getStories<br />
	 * @return the stories
	 *
	 * <b>created at</b> Mar 15, 2016 11:47:04 PM
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
	 * <b>created at</b> Mar 15, 2016 11:47:04 PM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setStories(List<Story> argStories)
	{
		this.stories = argStories;
	}
}
