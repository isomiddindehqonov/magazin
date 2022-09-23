package imtixon.service;

import imtixon.dto.ProductTypesDto;
import imtixon.dto.ResponseDto;

import java.util.List;

public interface ProductTypesService {
    ResponseDto<List<ProductTypesDto>> getAll();

    ResponseDto<ProductTypesDto> getById(Integer id);
}
