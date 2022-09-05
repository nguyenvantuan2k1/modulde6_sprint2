package com.example.beclothesshop.services;

import com.example.beclothesshop.model.dto.OrderDetailDTO;


import java.util.List;

public interface OrderDetailsService {
    OrderDetailDTO save(OrderDetailDTO orderDetailDTO);

    List<OrderDetailDTO> getAllByOrderId(Long id);
}
