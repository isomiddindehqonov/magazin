package imtixon.service;

import imtixon.dto.ExportDto;
import imtixon.dto.ResponseDto;

public interface Exchange {
    ResponseDto save(ExportDto exportDto);
    ResponseDto buy(Integer id);
}
