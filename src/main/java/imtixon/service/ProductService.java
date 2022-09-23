package imtixon.service;

import imtixon.dto.ProductDto;
import imtixon.dto.ResponseDto;

import java.util.List;

public interface ProductService {
    ResponseDto<List<ProductDto>> getAll();
    ResponseDto<ProductDto> findById(Integer id);
    ResponseDto update(ProductDto productDto);
    ResponseDto deleteById(Integer id);
    ResponseDto<List<ProductDto>> getAllByPage(Integer page, Integer size);
}
