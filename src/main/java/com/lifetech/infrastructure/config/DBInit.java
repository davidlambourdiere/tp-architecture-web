package com.lifetech.infrastructure.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    @PostConstruct
    @Transactional
    public void init(){

    }
}
