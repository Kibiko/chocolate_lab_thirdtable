package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.CocoaOrderDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocoaOrderService {

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    public List<CocoaOrder> findAllCocoaOrders(){
        return cocoaOrderRepository.findAll();
    }

    public List<CocoaOrder> saveCocoaOrder(CocoaOrderDTO cocoaOrderDTO){
        Chocolate chocolate = chocolateService.findChocolate(cocoaOrderDTO.getChocolateId());
        Estate estate = estateService.findEstate(cocoaOrderDTO.getEstateId());
        CocoaOrder cocoaOrder = new CocoaOrder(
                chocolate,
                estate,
                cocoaOrderDTO.getBatchNumber(),
                cocoaOrderDTO.getPricePaid()
        );
        cocoaOrderRepository.save(cocoaOrder);
        return cocoaOrderRepository.findAll();
    }
}
