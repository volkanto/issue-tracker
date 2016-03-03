package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.BugStatus;

/**
 * <b>Project issue-tracker</b><br />
 * BugStatusRepository.java<br />
 *
 * <b>created at</b> Mar 3, 2016 9:29:53 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface BugStatusRepository extends JpaRepository<BugStatus, Integer>
{

}
