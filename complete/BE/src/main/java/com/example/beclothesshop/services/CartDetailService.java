package com.example.beclothesshop.services;


import com.example.beclothesshop.model.dto.CartDetailDTO;

import java.util.List;

public interface CartDetailService {
    CartDetailDTO save(CartDetailDTO cartDetailDTO);

    CartDetailDTO update(CartDetailDTO cartDetailDTO);

    void delete(Long id);

    List<CartDetailDTO> getByCartId(Long id);

    CartDetailDTO getById(Long id);
}
