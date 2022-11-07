package com.example.seller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value="api/v1/seller")
public class SellerController {
    private DeliveryRepository deliveryRepository;

    @GetMapping(value = ("/delivery"))
    public List<Delivery> getDeliveries(){
        return deliveryRepository.findAll();
    }

}
