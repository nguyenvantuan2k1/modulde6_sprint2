package com.example.beclothesshop.common.converter;


import com.example.beclothesshop.model.dto.OrderDTO;
import com.example.beclothesshop.model.dto.OrderDetailDTO;
import com.example.beclothesshop.model.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Order toEntity(OrderDTO orderDTO) {

		Order Order = modelMapper.map(orderDTO, Order.class);

		return Order;

	}

	public OrderDTO toDTO(Order order) {

		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		
		if(orderDTO.getOrderDetails() != null) {
			for (OrderDetailDTO item : orderDTO.getOrderDetails()) {
				item.setOrder(null);
			}

		}
		return orderDTO;
	}
	
	public Page<OrderDTO> toPageDto(Page<Order> objects) {
	    Page<OrderDTO> dtos  = objects.map(this::toDTO);
	    return dtos;
	}

}
