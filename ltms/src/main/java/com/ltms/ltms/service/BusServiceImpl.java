package com.ltms.ltms.service;

import com.ltms.ltms.entity.BusEntity;
import com.ltms.ltms.models.BusModel;
import com.ltms.ltms.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    @Override
    public BusEntity findBusById(Long busId) {

        BusEntity busEntity = busRepository.findById(busId)
                .orElseThrow();
        return busEntity;
    }

    @Override
    public BusEntity createBus(BusModel busModel) {
        BusEntity bus = BusEntity.builder()//no need to build constructor
                .name(busModel.getName())
                .price(busModel.getPrice())
                .route(busModel.getRoute())
                .build();

        BusEntity savedBus =  busRepository.save(bus);//elborated
        return savedBus;
    }

    @Override
    public List<BusEntity> getBusList() {
        List<BusEntity> busEntityList = busRepository.findAll();
        return busEntityList;
    }

    @Override
    public BusEntity updateBus(BusModel busModel, Long busId) {
        BusEntity busFromDB = busRepository.findById(busId)
                .orElseThrow();
        if (busModel.getPrice() != null) busFromDB.setPrice(busModel.getPrice());
        if (busModel.getRoute() != null) busFromDB.setRoute(busModel.getRoute());
        BusEntity updatedBus = busRepository.save(busFromDB);
        return updatedBus;
    }

    @Override
    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }


}