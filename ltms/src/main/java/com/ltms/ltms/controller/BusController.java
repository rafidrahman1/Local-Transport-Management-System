package com.ltms.ltms.controller;

import com.ltms.ltms.entity.BusEntity;
import com.ltms.ltms.models.BusModel;
import com.ltms.ltms.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor

public class BusController{
    private final BusService busService;
    public ResponseEntity<List<BusEntity>> getAllBus(){
        List<BusEntity> allBus = busService.getBusList();

        //all bus return hobe
        return new ResponseEntity<>(allBus, HttpStatus.OK);
    }
    @GetMapping //http request to get info from database
    public ResponseEntity<BusEntity> getBusByID(long busID){

        //1 ta bus
        return null;
    }

    @PostMapping("/create") //http request to post in database
    public ResponseEntity<BusEntity> createBus(@RequestBody BusModel busModel){

        BusEntity busEntity = busService.createBus(busModel);

        return new ResponseEntity<>(busEntity, HttpStatus.OK);
    }
}
