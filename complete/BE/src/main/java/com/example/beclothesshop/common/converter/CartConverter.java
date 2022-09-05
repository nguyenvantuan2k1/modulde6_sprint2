package com.example.beclothesshop.common.converter;


import com.example.beclothesshop.model.dto.CartDTO;
import com.example.beclothesshop.model.dto.CartDetailDTO;
import com.example.beclothesshop.model.entity.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

	@Autowired
	ModelMapper modelMapper;

	public Cart toEntity(CartDTO cartDTO) {

		Cart cart = modelMapper.map(cartDTO, Cart.class);

		return cart;

	}

	public CartDTO toDTO(Cart cart) {

		CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		for (CartDetailDTO item : cartDTO.getCartDetails()) {
			item.setCart(null);
		}

		return cartDTO;
	}

}
