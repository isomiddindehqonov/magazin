package imtixon.mapper;

import imtixon.dto.OrdersDto;
import imtixon.entity.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Orders toEntity(OrdersDto ordersDto);
    OrdersDto toDto(Orders orders);
}
