package com.example.seller;

import com.example.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SellerService {
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getSeller(){
        return deliveryRepository.findAll();
    }

    public void saveDelivery(OrderRequest orderRequest){
        log.info("SellerService - saveDelivery New delivery received");
        deliveryRepository.save(Delivery.builder().customerId(orderRequest.customerId()).productId(orderRequest.productId())
                .createdAt(orderRequest.createdAt()).status("new").build());
    }

}
