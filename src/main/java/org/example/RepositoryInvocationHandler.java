package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RepositoryInvocationHandler implements InvocationHandler {
    private final Repository userService;

    private final Set<Method> methodSet = Arrays.stream(Repository.class.getMethods()).collect(Collectors.toSet());

    public RepositoryInvocationHandler(Repository repository) {
        this.userService = repository;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==================Before method " + method.getName());
        if (methodSet.contains(method)) {
            Object result = method.invoke(userService, args);
            System.out.println("==================After method " + method.getName());
            return result;
        }else {
            System.out.println("method not found");
            System.out.println("==================After method " + method.getName());
            return method.getName();
        }

    }
}
