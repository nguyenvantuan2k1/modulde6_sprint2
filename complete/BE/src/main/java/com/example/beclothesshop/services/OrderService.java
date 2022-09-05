package com.example.beclothesshop.services;


import com.example.beclothesshop.model.dto.ChartStatistical;
import com.example.beclothesshop.model.dto.OrderDTO;
import com.example.beclothesshop.model.dto.StatisticByDate;
import com.example.beclothesshop.model.dto.StatisticByProduct;
import com.example.beclothesshop.model.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    Page<OrderDTO> getByUserId(Long id, Integer page, Integer size);

    OrderDTO getById(Long id);

    Page<OrderDTO> getAll(Integer page, Integer size);

    List<Order> statisticByDate(StatisticByDate statisticByDate);

    List<Order> statisticByProduct(StatisticByProduct statisticByProduct);

    List<ChartStatistical> setPerformanceWithChartList();

    List<ChartStatistical> totalsOfUses();
}
