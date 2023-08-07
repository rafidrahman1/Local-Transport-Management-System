package com.ltms.ltms.service;

import com.ltms.ltms.entity.BusEntity;
import com.ltms.ltms.models.BusModel;

import java.util.List;

public interface BusService {
    BusEntity findBusById(Long id);
    BusEntity createBus(BusModel busModel);
    List<BusEntity> getBusList();

}
