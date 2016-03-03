package org.tokmak.pinguin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * <b>Project issue-tracker</b><br />
 * ServletInitializer.java<br />
 *
 * <b>created at</b> Mar 3, 2016 9:36:30 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public class ServletInitializer extends SpringBootServletInitializer
{
	/**
	 * ServletInitializer<br />
	 *
	 * @param application
	 * @return
	 *
	 * <b>created at</b> Mar 3, 2016 9:36:32 PM
	 * @since 0.0.1
	 * @author Volkan Tokmak
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(IssueTrackerApplication.class);
	}
}
