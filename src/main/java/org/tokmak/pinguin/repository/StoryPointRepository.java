package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.StoryPoint;

/**
 * <b>Project issue-tracker</b><br />
 * StoryPointRepository.java<br />
 *
 * <b>created at</b> Mar 6, 2016 5:22:56 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface StoryPointRepository extends JpaRepository<StoryPoint, Integer>
{

}
