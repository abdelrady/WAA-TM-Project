package edu.mum.tm.serviceImpl;

import java.util.List;

import edu.mum.tm.domain.Role;
import edu.mum.tm.repository.RoleRepository;
import edu.mum.tm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Role get(Long id) {

        return roleRepository.findById(id).get();
    }
}
