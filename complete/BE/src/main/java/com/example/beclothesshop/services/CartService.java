package com.example.beclothesshop.services;


import com.example.beclothesshop.model.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> findByUserId(Long id);
}
