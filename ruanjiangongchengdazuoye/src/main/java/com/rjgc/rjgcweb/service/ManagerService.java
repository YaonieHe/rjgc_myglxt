package com.rjgc.rjgcweb.service;

/**
 * Created by hejiangping on 2018/5/2
 */

import com.rjgc.rjgcweb.entity.Manager;
import com.rjgc.rjgcweb.repository.ManagerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ManagerService {

  @Autowired
  private ManagerRepository managerRepository;

  public void updateUserPassword(Long id, String password) {
    Optional<Manager> manager = managerRepository.findById(id);
    if (manager.isPresent()) {
      manager.get().setPassword(password);
      managerRepository.save(manager.get());
    }
  }

  public boolean login(String username, String password) {
	System.out.println("service");
    Optional<Manager> manager = managerRepository.findByUsername(username);
    if (manager.isPresent() && StringUtils.equals(manager.get().getPassword(), password)) {
      return true;
    } else {
      return false;
    }
  }

}
