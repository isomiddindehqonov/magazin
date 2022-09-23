package imtixon.controller;

import imtixon.dto.OrdersProductDto;
import imtixon.dto.ResponseDto;
import imtixon.service.OrdersProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/ordersProduct")
public class OrdersProductController {
    private final OrdersProductService service;
    @PostMapping
    public ResponseDto add(@RequestBody OrdersProductDto ordersProductDto) {
        return service.add(ordersProductDto);
    }
    @GetMapping
    public ResponseDto<List<OrdersProductDto>> getAll() {
        return service.getAll();
    }
    @PutMapping
    public ResponseDto update(@RequestBody OrdersProductDto ordersProductDto) {
        return service.update(ordersProductDto);
    }
    @DeleteMapping("/{id}")
    public ResponseDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
