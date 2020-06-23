package com.todolist.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Status implements GrantedAuthority {
  STATUS_TODO, STATUS_DONE;

  public String getAuthority() {
    return name();
  }

}
