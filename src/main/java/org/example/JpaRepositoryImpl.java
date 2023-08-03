package org.example;

public class JpaRepositoryImpl implements JpaRepository{
    @Override
    public String findByName() {
        return "JpaRepositoryImpl";
    }

    @Override
    public String getName() {
        return "JpaRepositoryImpl";
    }
}
