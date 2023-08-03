package org.example.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MysqlUserServiceImpl implements UserService{
    @Override
    public List<String> getUsers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("mysql:"+String.valueOf(i));
        }

        return list;
    }

    @Override
    public String getUserById(Integer id) {
        return "mysql:"+id.toString();
    }

    @Override
    public String serviceName() {
        return "MysqlUserServiceImpl";
    }
}
