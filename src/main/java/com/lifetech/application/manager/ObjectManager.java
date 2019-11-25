package com.lifetech.application.manager;

import com.lifetech.application.dto.ObjectDTO;

import java.util.List;

public interface ObjectManager {
    List<ObjectDTO> findAll();
}
