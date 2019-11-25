package com.demospringboot.application.manager;

import com.demospringboot.application.dto.ObjectDTO;

import java.util.List;

public interface ObjectManager {
    List<ObjectDTO> findAll();
}
