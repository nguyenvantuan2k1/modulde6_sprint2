package com.example.beclothesshop.services.impl;

import com.example.beclothesshop.common.converter.RateConverter;
import com.example.beclothesshop.common.exception.ResourceNotFoundException;
import com.example.beclothesshop.model.dto.RateDTO;
import com.example.beclothesshop.model.entity.Product;
import com.example.beclothesshop.model.entity.Rates;
import com.example.beclothesshop.model.entity.User;
import com.example.beclothesshop.repositories.ProductRepository;
import com.example.beclothesshop.repositories.RateRepository;
import com.example.beclothesshop.repositories.UserRepository;
import com.example.beclothesshop.services.RateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl  implements RateService {

    @Autowired
    RateRepository rateRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RateConverter rateConverter;

    @Autowired
    UserRepository userRepository;

    @Override
    public RateDTO save(RateDTO rateDTO) {
        Product product = productRepository.findById(rateDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + rateDTO.getProductId()));
        User user = userRepository.getById(rateDTO.getUserId());
        Rates rates = rateConverter.toEntity(rateDTO);
        rates.setProduct(product);
        rates.setUser(user);
        Rates _rates = rateRepository.save(rates);
        return rateConverter.toDTO(_rates);

    }
}
