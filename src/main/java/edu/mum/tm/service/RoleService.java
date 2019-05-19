package edu.mum.tm.service;

import edu.mum.tm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role get(Long id);
}
