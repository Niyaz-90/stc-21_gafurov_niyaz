package ru.inno.service;

import org.springframework.stereotype.Service;
import ru.inno.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private Map<Integer, User> USER_LIST = new HashMap<>();
    private static final AtomicInteger USER_ID = new AtomicInteger();

    public void create(User user){
        USER_LIST.put(USER_ID.incrementAndGet(), user);
    }

    public User getById(int id){
        return USER_LIST.get(id);
    }

    public List<User> getAll(){
        return new ArrayList<>(USER_LIST.values());
    }
}
