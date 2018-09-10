package com.qing.consumer;

import com.qing.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findOneByUsername(String username);

    List<User> findList(Integer page, Integer size);
}
