package imtixon.service.Impl;

import imtixon.dto.ProductDto;
import imtixon.dto.ResponseDto;
import imtixon.entity.Product;
import imtixon.mapper.ProductMapper;
import imtixon.repository.ProductRepository;
import imtixon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    @Override
    public ResponseDto<List<ProductDto>> getAll() {
        List<Product> products= repository.findAll();
        return ResponseDto.<List<ProductDto>>builder().code(0).message("Success").success(true).data(mapper.toDtoList(products)).build();
    }

    @Override
    public ResponseDto<ProductDto> findById(Integer id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()) {
            return ResponseDto.<ProductDto>builder().code(-1).message("Not Found").success(false).build();
        }
        return ResponseDto.<ProductDto>builder().code(0).message("Success").data(mapper.toDto(product.get())).success(true).build();
    }

    @Override
    public ResponseDto update(ProductDto productDto) {
        if(repository.existsById(productDto.getId())) {
            repository.save(mapper.toEntity(productDto));
            return ResponseDto.builder().code(0).success(true).message("Success").build();
        }
        return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
    }

    @Override
    public ResponseDto deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseDto.builder().code(0).success(true).message("Success").build();
        }
        return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
    }

    @Override
    public ResponseDto<List<ProductDto>> getAllByPage(Integer page, Integer size) {
        PageRequest request = PageRequest.of(page,size);
        List<Product> list = (List<Product>) repository.findAll(request);

        return ResponseDto.<List<ProductDto>>builder().code(0).message("Success").data(mapper.toDtoList(list)).success(true).build();
    }
}
