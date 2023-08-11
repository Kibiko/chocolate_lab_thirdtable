package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    public Chocolate updateChocolate(ChocolateDTO chocolateDTO, Long id){
        Chocolate chocolateToUpdate = chocolateRepository.findById(id).get();
        chocolateToUpdate.setName(chocolateDTO.getName());
        chocolateToUpdate.setCocoaPercentage(chocolateDTO.getCocoaPercentage());
//        chocolateToUpdate.setCocoaOrders(new ArrayList<CocoaOrder>());
//        for (Long cocoaOrderId : chocolateDTO.getCocoaOrderIds()){
//            CocoaOrder cocoaOrder = cocoaOrderRepository.findById(cocoaOrderId).get();
//            chocolateToUpdate.addCocoaOrder(cocoaOrder);
//        }
        chocolateRepository.save(chocolateToUpdate);
        return chocolateToUpdate;
    }

    public void saveChocolate(ChocolateDTO chocolateDTO) {
        Chocolate chocolate = new Chocolate(chocolateDTO.getName(), chocolateDTO.getCocoaPercentage());

//        for (Long cocoaOrderId : chocolateDTO.getCocoaOrderIds()){
//            CocoaOrder cocoaOrder = cocoaOrderRepository.findById(cocoaOrderId).get();
//            chocolate.addCocoaOrder(cocoaOrder);
//        }
        chocolateRepository.save(chocolate);
    }

    public Chocolate findChocolate(Long id){
       return chocolateRepository.findById(id).get();
    }

    public List<Chocolate> findAllChocolates(){
        return chocolateRepository.findAll();
    }

    public List<Chocolate> findAllChocolatesOverCocoaPercentage(int percentage){
        return chocolateRepository.findByCocoaPercentageGreaterThan(percentage);
    }

    public void deleteChocolate(Long id){
        chocolateRepository.deleteById(id);
    }


}
