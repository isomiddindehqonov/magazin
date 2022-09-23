package imtixon.service;

import imtixon.dto.OrdersDto;
import imtixon.dto.ResponseDto;

import java.util.List;

public interface OrdersService {
    ResponseDto add(OrdersDto ordersDto);
    ResponseDto<List<OrdersDto>> getAll();
    ResponseDto<OrdersDto> getById(Integer id);
    ResponseDto update(OrdersDto ordersDto);
    ResponseDto deleteById(Integer id);

}
