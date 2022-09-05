package com.example.beclothesshop.common.converter;


import com.example.beclothesshop.model.dto.OrderDetailDTO;
import com.example.beclothesshop.model.entity.OrderDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	public OrderDetail toEntity(OrderDetailDTO orderDetailDTO) {

		OrderDetail orderDetail = modelMapper.map(orderDetailDTO, OrderDetail.class);

		return orderDetail;

	}

	public OrderDetailDTO toDTO(OrderDetail orderDetail) {

		OrderDetailDTO orderDetailDTO = modelMapper.map(orderDetail, OrderDetailDTO.class);
		
		orderDetailDTO.setOrder(null);
		
//		for (RateDTO item : orderDetailDTO.getProduct().getRates()) {
//			item.setProduct(null);
//		}

		return orderDetailDTO;
	}

}
