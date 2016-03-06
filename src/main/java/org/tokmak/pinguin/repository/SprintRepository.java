package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.Sprint;

/**
 * <b>Project issue-tracker</b><br />
 * SprintRepository.java<br />
 *
 * <b>created at</b> Mar 5, 2016 7:21:42 PM
 * @author Volkan Tokmak
 * @since 0.0.1
 */
public interface SprintRepository extends JpaRepository<Sprint, Integer>
{

}