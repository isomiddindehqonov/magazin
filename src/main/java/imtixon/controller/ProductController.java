package imtixon.controller;

import imtixon.dto.ProductDto;
import imtixon.dto.ResponseDto;
import imtixon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController  {
    private final ProductService service;
    @GetMapping
    public ResponseDto<List<ProductDto>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseDto<ProductDto> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @PutMapping
    public ResponseDto update(@RequestBody ProductDto productDto) {
        return service.update(productDto);
    }
    @DeleteMapping("/{id}")
    public ResponseDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
    @GetMapping("/page")
    public ResponseDto<List<ProductDto>> getAllByPage(@RequestParam Integer page,@RequestParam Integer size) {
        return service.getAllByPage(page,size);
    }
}
