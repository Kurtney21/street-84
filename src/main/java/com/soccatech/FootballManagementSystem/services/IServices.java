package com.soccatech.FootballManagementSystem.services;

import java.util.List;

public interface IServices <T,X>{
    T create(T t);
    List<T> findAll();
    T update(T t, X x);
    boolean delete(X x);
}
