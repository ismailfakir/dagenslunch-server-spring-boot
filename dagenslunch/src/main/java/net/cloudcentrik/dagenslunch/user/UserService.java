package net.cloudcentrik.dagenslunch.user;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(Long id);
}
