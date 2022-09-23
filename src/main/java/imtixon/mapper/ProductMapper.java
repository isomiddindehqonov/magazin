package imtixon.mapper;

import imtixon.dto.ProductDto;
import imtixon.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity (ProductDto productDto);
    ProductDto toDto (Product product);
    List<Product> toEntityList(List<ProductDto> productDtoList);
    List<ProductDto> toDtoList(List<Product> productList);
}
