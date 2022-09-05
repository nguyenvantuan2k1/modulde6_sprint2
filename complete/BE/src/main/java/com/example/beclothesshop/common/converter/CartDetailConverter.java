package com.example.beclothesshop.common.converter;


import com.example.beclothesshop.model.dto.CartDetailDTO;
import com.example.beclothesshop.model.entity.CartDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDetailConverter {
	
	@Autowired
	ModelMapper modelMapper;

	public CartDetail toEntity(CartDetailDTO cartDetailDTO) {

		CartDetail cartDetail = modelMapper.map(cartDetailDTO, CartDetail.class);

		return cartDetail;

	}

	public CartDetailDTO toDTO(CartDetail cart) {

		CartDetailDTO cartDetailDTO = modelMapper.map(cart, CartDetailDTO.class);
		
		cartDetailDTO.getCart().setCartDetails(null);
		
//		for (RateDTO item : cartDetailDTO.getProduct().getRates()) {
//			item.setProduct(null);
//		}

		return cartDetailDTO;
	}


}
