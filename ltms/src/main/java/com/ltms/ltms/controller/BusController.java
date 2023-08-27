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
    @GetMapping("/all")
    public ResponseEntity<List<BusEntity>> getAllBus(){

        List<BusEntity> allBus = busService.getBusList();

        //all bus return hobe
        return new ResponseEntity<>(allBus, HttpStatus.OK);
    }
    @GetMapping("/{busId}") //http request to get info from database
    public ResponseEntity<BusEntity> getBusById(@PathVariable long busId){
        BusEntity busEntity = busService.findBusById(busId);
        return new ResponseEntity<>(busEntity, HttpStatus.OK);

        //1 ta bus

    }

    @PostMapping("/create") //http request to post in database
    public ResponseEntity<BusEntity> createBus(@RequestBody BusModel busModel){
        BusEntity busEntity = busService.createBus(busModel);
        return new ResponseEntity<>(busEntity, HttpStatus.OK);
    }

    @PutMapping("/update/{busId}")
    public ResponseEntity<BusEntity> updateBus(@RequestBody BusModel busModel, @PathVariable Long busId){
        BusEntity busEntity = busService.updateBus(busModel, busId);
        return new ResponseEntity<>(busEntity, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{busId}")
    public ResponseEntity<Object> deleteMapping(@PathVariable Long busId){
        busService.deleteBus(busId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
