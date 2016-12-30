package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.model.Role;
import com.mgmtp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Employee employee = employeeRepository.findByEmail(email);
            if (employee == null) {
                return null;
            }
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
        return authorities;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getCurrentEmployee() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        Employee currentEmployee = employeeRepository.findByEmail(email);
        currentEmployee.getApprovers().size();
        return  currentEmployee;
    }
}
