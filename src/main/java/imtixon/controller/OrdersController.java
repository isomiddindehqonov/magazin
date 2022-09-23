package imtixon.controller;

import imtixon.dto.OrdersDto;
import imtixon.dto.ResponseDto;
import imtixon.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrdersController {
    private final OrdersService service;
    @PostMapping
    public ResponseDto add(@RequestBody OrdersDto ordersDto) {
        return service.add(ordersDto);
    }
    @GetMapping
    public ResponseDto<List<OrdersDto>> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseDto<OrdersDto> getById(@PathVariable Integer id) {
        return service.getById(id);
    }
    @PutMapping
    public ResponseDto update(@RequestBody OrdersDto ordersDto) {
        return service.update(ordersDto);
    }
    @DeleteMapping("/{id}")
    public ResponseDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
