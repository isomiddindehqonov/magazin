package imtixon.service;

import imtixon.dto.OrdersProductDto;
import imtixon.dto.ResponseDto;

import java.util.List;

public interface OrdersProductService {
    ResponseDto add(OrdersProductDto ordersProductDto);
    ResponseDto<List<OrdersProductDto>> getAll();
    ResponseDto update(OrdersProductDto ordersProductDto);
    ResponseDto deleteById(Integer id);
}
