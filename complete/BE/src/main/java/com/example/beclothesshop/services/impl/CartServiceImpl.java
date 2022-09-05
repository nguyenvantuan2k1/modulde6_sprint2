package com.example.beclothesshop.services.impl;


import com.example.beclothesshop.common.converter.CartConverter;
import com.example.beclothesshop.model.dto.CartDTO;
import com.example.beclothesshop.model.entity.Cart;
import com.example.beclothesshop.repositories.CartRepository;
import com.example.beclothesshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartConverter cartConverter;

    @Override
    public List<CartDTO> findByUserId(Long id) {
        List<Cart> carts = cartRepository.findByUserId(id);
        List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
        for (Cart cart : carts) {
            cartDTOs.add(cartConverter.toDTO(cart));
        }
        return cartDTOs;
    }
}
