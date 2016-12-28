package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.model.Role;
import com.mgmtp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeDetailsService implements UserDetailsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDetailsService.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Employee employee = employeeRepository.findByEmail(email);
            if (employee == null) {
                LOGGER.debug("employee not found with the provided email");
                return null;
            }
            LOGGER.debug(" employee from username " + employee.getFullName());
            return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), getAuthorities(employee));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(Employee employee){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : employee.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        LOGGER.debug("employee authorities are " + authorities.toString());
        return authorities;
    }
}
