package imtixon.service.Impl;

import imtixon.dto.ProductTypesDto;
import imtixon.dto.ResponseDto;
import imtixon.entity.Product;
import imtixon.entity.ProductTypes;
import imtixon.mapper.ProductTypesMapper;
import imtixon.repository.ProductTypesRepository;
import imtixon.service.ProductTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class ProductTypesServiceImpl implements ProductTypesService {
    private final ProductTypesRepository repository;
    private final ProductTypesMapper mapper;
    @Override
    public ResponseDto<List<ProductTypesDto>> getAll() {
        List<ProductTypes> productTypes = repository.findAll();


        return ResponseDto.<List<ProductTypesDto>>builder().code(2).message("Success").data(mapper.toList(productTypes)).build();
    }

    @Override
    public ResponseDto<ProductTypesDto> getById(Integer id) {
        Optional<ProductTypes> productTypes = repository.findById(id);
        if(productTypes.isEmpty()) {
            return ResponseDto.<ProductTypesDto>builder().code(-1).message("Not Found").success(false).build();
        }
        return ResponseDto.<ProductTypesDto>builder().code(0).message("Success").data(mapper.toDto(productTypes.get())).success(true).build();
    }

}
