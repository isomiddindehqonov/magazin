package imtixon.service.Impl;

import imtixon.dto.OrdersDto;
import imtixon.dto.ResponseDto;
import imtixon.entity.Orders;
import imtixon.mapper.OrdersMapper;
import imtixon.repository.OrdersRepository;
import imtixon.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
//    @Autowired
    private final OrdersRepository repository;
    private final OrdersMapper mapper;
    @Override
    public ResponseDto add(OrdersDto ordersDto) {
        repository.save(mapper.toEntity(ordersDto));
        return ResponseDto.builder().code(0).success(true).message("Success").build();
    }

    @Override
    public ResponseDto<List<OrdersDto>> getAll() {
        List<Orders> orders = repository.findAll();
        List<OrdersDto> ordersDtoList = orders.stream().map(m ->mapper.toDto(m)).collect(Collectors.toList());
        return ResponseDto.<List<OrdersDto>>builder().code(0).message("Success").data(ordersDtoList).success(true).build();
    }

    @Override
    public ResponseDto<OrdersDto> getById(Integer id) {
        Optional<Orders> ordersDto =  repository.findById(id);
        if(ordersDto.isEmpty()) {
            return ResponseDto.<OrdersDto>builder().message("Not Found").code(-3).success(false).build();
        }
        return ResponseDto.<OrdersDto>builder().message("Success").code(0).success(true).data(mapper.toDto(ordersDto.get())).build();
    }

    @Override
    public ResponseDto update(OrdersDto ordersDto) {
        if(repository.existsById(ordersDto.getId())) {
            repository.save(mapper.toEntity(ordersDto));
            return ResponseDto.builder().code(0).message("Success").success(true).build();
        }

        return ResponseDto.builder().code(-5).message("Not Found").success(false).build();

    }

    @Override
    public ResponseDto deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseDto.builder().code(0).message("Success").success(true).build();
        }
        return ResponseDto.builder().code(-5).message("Not Found").success(false).build();
    }
}
