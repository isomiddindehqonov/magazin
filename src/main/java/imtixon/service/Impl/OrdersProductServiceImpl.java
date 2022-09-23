package imtixon.service.Impl;

import imtixon.dto.OrdersProductDto;
import imtixon.dto.ResponseDto;
import imtixon.entity.OrdersProduct;
import imtixon.mapper.OrdersProductMapper;
import imtixon.repository.OrdersProductRepository;
import imtixon.service.OrdersProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class OrdersProductServiceImpl implements OrdersProductService {
    private final OrdersProductRepository repository;
    public final OrdersProductMapper mapper;
    @Override
    public ResponseDto add(OrdersProductDto ordersProductDto) {
        repository.save(mapper.toEntity(ordersProductDto));
        return ResponseDto.builder().code(0).message("Success").success(true).build();
    }

    @Override
    public ResponseDto<List<OrdersProductDto>> getAll() {
        List<OrdersProduct> ordersProducts =  repository.findAll();
        List<OrdersProductDto> ordersProductDtoList = ordersProducts.stream().map(m ->mapper.toDto(m)).collect(Collectors.toList());
        return ResponseDto.<List<OrdersProductDto>>builder().code(0).message("Success").success(true).data(ordersProductDtoList).build();
    }

    @Override
    public ResponseDto update(OrdersProductDto ordersProductDto) {
        if(repository.existsById(ordersProductDto.getId())) {
            repository.save(mapper.toEntity(ordersProductDto));
            return ResponseDto.builder().code(0).message("Success").success(true).build();
        }
        return ResponseDto.builder().code(-1).message("Not Found").success(false).build();

    }

    @Override
    public ResponseDto deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseDto.builder().code(0).message("Success").success(true).build();
        }
        return ResponseDto.builder().code(-1).message("Not found").success(false).build();
    }
}
