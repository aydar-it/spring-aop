package com.geekbrains.book.store.beans;

import lombok.Getter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AspectLogs {
    @Getter
    private Map<String, Integer> logs;

    @PostConstruct
    public void init() {
        logs = new HashMap<>();
        logs.put("BookService", 0);
        logs.put("OrderService", 0);
        logs.put("UserService", 0);
    }

    @Before("execution(public * com.geekbrains.book.store.services.BookService.*(..))")
    public void beforeBookServiceMethod() {
        logs.put("BookService", logs.get("BookService") + 1);
    }

    @Before("execution(public * com.geekbrains.book.store.services.OrderService.*(..))")
    public void beforeOrderServiceMethod() {
        logs.put("OrderService", logs.get("OrderService") + 1);
    }

    @Before("execution(public * com.geekbrains.book.store.services.UserService.*(..))")
    public void beforeUserServiceMethod() {
        logs.put("UserService", logs.get("UserService") + 1);
    }
}
