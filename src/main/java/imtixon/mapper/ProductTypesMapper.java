package imtixon.mapper;

import imtixon.dto.ProductTypesDto;
import imtixon.entity.ProductTypes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductTypesMapper {
    ProductTypes toEntity(ProductTypesDto productTypesDto);
    ProductTypesDto toDto(ProductTypes productTypes);
    List<ProductTypesDto> toList(List<ProductTypes> productTypes);
}
