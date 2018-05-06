package com.rjgc.rjgcweb.repository;

import com.rjgc.rjgcweb.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by hejiangping on 2018/5/2.
 */
@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
  Optional<Manager> findByUsername(String username);
}
