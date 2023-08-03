package org.example.spi;

import java.util.List;

public interface UserService {

    List<String> getUsers();

    String getUserById(Integer id);


    default String serviceName(){
        return "UserService";
    }
}
