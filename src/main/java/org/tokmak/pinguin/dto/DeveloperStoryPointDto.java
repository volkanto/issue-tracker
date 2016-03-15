package org.tokmak.pinguin.dto;

/**
 * <b>Project issue-tracker</b><br />
 * DeveloperStoryPointDto.java<br />
 *
 * <b>created at</b> Mar 13, 2016 1:14:38 AM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public class DeveloperStoryPointDto
{
	private Integer developerId = null;
	private Integer points		= null;
	/**
	 * getDeveloperId<br />
	 * @return the developerId
	 *
	 * <b>created at</b> Mar 13, 2016 1:15:15 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Integer getDeveloperId()
	{
		return this.developerId;
	}
	/**
	 * setDeveloperId<br />
	 *
	 * @param argDeveloperId the developerId to set
	 *
	 * <b>created at</b> Mar 13, 2016 1:15:15 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setDeveloperId(Integer argDeveloperId)
	{
		this.developerId = argDeveloperId;
	}
	/**
	 * getPoints<br />
	 * @return the points
	 *
	 * <b>created at</b> Mar 13, 2016 1:15:15 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public Integer getPoints()
	{
		return this.points;
	}
	/**
	 * setPoints<br />
	 *
	 * @param argPoints the points to set
	 *
	 * <b>created at</b> Mar 13, 2016 1:15:15 AM
	 * @author Volkan Tokmak
	 * @since 0.0.1
	 */
	public void setPoints(Integer argPoints)
	{
		this.points = argPoints;
	}
}
