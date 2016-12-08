package com.mgmtp.repository;

import com.mgmtp.model.User;

import java.util.List;

/**
 * Created by Tan Dat on 08/12/2016.
 */
public interface UserRepository {
    public List<User> findAll();
    public void save(User user);
}
