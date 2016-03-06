package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.StoryStatus;

/**
 * <b>Project issue-tracker</b><br />
 * StoryStatusRepository.java<br />
 *
 * <b>created at</b> Mar 6, 2016 5:22:19 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface StoryStatusRepository extends JpaRepository<StoryStatus, Integer>
{

}
