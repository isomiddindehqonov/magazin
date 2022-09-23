package imtixon.controller;

import imtixon.dto.ExportDto;
import imtixon.dto.ResponseDto;
import imtixon.service.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/export")
public class ExportController {
    private final Exchange exchange;
    @PostMapping("/korzinka")
    public ResponseDto save(@RequestBody ExportDto exportDto) {
        return exchange.save(exportDto);
    }
    @PostMapping("/{id}")
    public ResponseDto buy(@PathVariable Integer id) {
        return exchange.buy(id);
    }
}
