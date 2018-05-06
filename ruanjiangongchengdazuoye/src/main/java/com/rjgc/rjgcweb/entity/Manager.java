package com.rjgc.rjgcweb.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hejiangping on 2018-5-3
 */
@Entity
@Data
public class Manager {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  private String username;
  private String password;
}
