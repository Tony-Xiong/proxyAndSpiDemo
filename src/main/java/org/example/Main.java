package org.example;

import org.example.spi.UserService;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello world!");

        SimpleRepository simpleRepository = new SimpleRepository();
        JpaRepositoryImpl jpaRepository = new JpaRepositoryImpl();
        List<Class<?>> interfaces = ClassUtils.scanInterface(Main.class.getPackageName());
        JpaRepository proxy = (JpaRepository) Proxy.newProxyInstance(Repository.class.getClassLoader(), interfaces.toArray(Class[]::new), new RepositoryInvocationHandler( simpleRepository));
        JpaRepository proxy1 = (JpaRepository) Proxy.newProxyInstance(Repository.class.getClassLoader(), interfaces.toArray(Class[]::new), new RepositoryInvocationHandler( jpaRepository));
        System.out.println("proxy getName result = "+proxy.getName());
        System.out.println("proxy findByName result = "+proxy.findByName());

        System.out.println("proxy1 getName result = "+proxy1.getName());
        System.out.println("proxy1 findByName result = "+proxy1.findByName());
        System.out.println("jpaRepository getName result = "+jpaRepository.getName());
        System.out.println("jpaRepository findByName result = "+jpaRepository.findByName());
        List<Class<?>> classes = ClassUtils.scanClasses("org.example");
        classes.stream().filter(Class::isInterface).forEach(aClass -> System.out.println(aClass.getName()));

        ServiceLoader<UserService> services = ServiceLoader.load(UserService.class);
        for (UserService service : services) {
            String userById = service.getUserById(1);
            System.out.println(service.serviceName() + ":" + userById);
            System.out.println(String.join("|", service.getUsers()));
        }

    }
}