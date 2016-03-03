package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.BugPriority;

/**
 * <b>Project issue-tracker</b><br />
 * BugPriorityRepository.java<br />
 *
 * <b>created at</b> Mar 3, 2016 9:29:31 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface BugPriorityRepository extends JpaRepository<BugPriority, Integer>
{

}
