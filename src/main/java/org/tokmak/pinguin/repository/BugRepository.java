package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.Bug;

/**
 * <b>Project issue-tracker</b><br />
 * BugRepository.java<br />
 *
 * <b>created at</b> Mar 1, 2016 11:19:50 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface BugRepository extends JpaRepository<Bug, Integer>
{

}
