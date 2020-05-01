package com.infobeans.user.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobeans.user.model.User;

/**
 * @author Tomesh
 *
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}