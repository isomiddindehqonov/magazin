package imtixon.mapper;

import imtixon.dto.OrdersProductDto;
import imtixon.entity.OrdersProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersProductMapper {
    OrdersProduct toEntity(OrdersProductDto ordersProductDto);
    OrdersProductDto toDto(OrdersProduct ordersProduct);
}
