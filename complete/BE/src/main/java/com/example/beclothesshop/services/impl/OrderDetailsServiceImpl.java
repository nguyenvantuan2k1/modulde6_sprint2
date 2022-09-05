package com.example.beclothesshop.services.impl;


import com.example.beclothesshop.common.converter.OrderDetailConverter;
import com.example.beclothesshop.model.dto.OrderDetailDTO;
import com.example.beclothesshop.model.entity.OrderDetail;
import com.example.beclothesshop.repositories.OrderDetailRepository;
import com.example.beclothesshop.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderDetailConverter orderDetailConverter;

    @Override
    public OrderDetailDTO save(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO));

        return orderDetailConverter.toDTO(orderDetail);
    }

    @Override
    public List<OrderDetailDTO> getAllByOrderId(Long id) {
        List<OrderDetail> details = orderDetailRepository.findByOrderId(id);
        List<OrderDetailDTO> detailDTOs = new ArrayList<OrderDetailDTO>();
        for (OrderDetail orderDetail : details) {
            detailDTOs.add(orderDetailConverter.toDTO(orderDetail));
        }

        return detailDTOs;
    }
}
