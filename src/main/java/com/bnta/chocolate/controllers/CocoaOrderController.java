package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.CocoaOrderDTO;
import com.bnta.chocolate.services.CocoaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cocoa-orders") // localhost:8080/cocoa-orders
public class CocoaOrderController {

    @Autowired
    CocoaOrderService cocoaOrderService;

//  INDEX
    @GetMapping
    public ResponseEntity<List<CocoaOrder>> getAllCocoaOrders(){
        return new ResponseEntity<>(cocoaOrderService.findAllCocoaOrders(), HttpStatus.OK);
    }

//  CREATE
    @PostMapping
    public ResponseEntity<List<CocoaOrder>> createCocoaOrder(@RequestBody CocoaOrderDTO cocoaOrderDTO){
        List<CocoaOrder> cocoaOrders = cocoaOrderService.saveCocoaOrder(cocoaOrderDTO);
        return new ResponseEntity<>(cocoaOrders, HttpStatus.CREATED);
    }

}
