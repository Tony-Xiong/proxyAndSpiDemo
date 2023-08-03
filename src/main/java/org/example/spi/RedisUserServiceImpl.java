package org.example.spi;

import java.util.ArrayList;
import java.util.List;

public class RedisUserServiceImpl implements UserService{
    @Override
    public List<String> getUsers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("redis:"+String.valueOf(i));
        }

        return list;
    }

    @Override
    public String getUserById(Integer id) {
        return "redis:"+id.toString();
    }

    @Override
    public String serviceName() {
        return "RedisUserServiceImpl";
    }
}
