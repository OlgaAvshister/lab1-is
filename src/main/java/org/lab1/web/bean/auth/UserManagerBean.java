package org.lab1.web.bean.auth;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import org.lab1.data.CRUD;
import org.lab1.data.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@ApplicationScoped
public class UserManagerBean {
    public List<User> getRequestList() {
        return CRUD.findAll(User.class).stream().filter(User::isRequest).collect(Collectors.toList());
    }

    public void deniedRequest(User user) {
        CRUD.delete(user);
    }

    public void acceptRequest(User user) {
        user.setRequest(false);
        CRUD.update(user);
    }

}
