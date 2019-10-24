package com.alloum.nd.springbatchalloum.repository;

import com.alloum.nd.springbatchalloum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ALLOUM on 18/10/2019
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
