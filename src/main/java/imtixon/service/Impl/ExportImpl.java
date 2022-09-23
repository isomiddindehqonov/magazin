package imtixon.service.Impl;

import imtixon.dto.ExportDto;
import imtixon.dto.ResponseDto;
import imtixon.entity.Orders;
import imtixon.entity.OrdersProduct;
import imtixon.repository.OrdersProductRepository;
import imtixon.repository.OrdersRepository;
import imtixon.repository.ProductRepository;
import imtixon.service.Exchange;
import imtixon.service.OrdersProductService;
import imtixon.service.OrdersService;
import imtixon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExportImpl implements Exchange {
    private final ProductService productService;
    private final OrdersService ordersService;
    private final OrdersProductService ordersProductService;
    private final OrdersRepository ordersRepository;
    private final OrdersProductRepository ordersProductRepository;
    private final ProductRepository productRepository;
    private final Orders orders1;
    private final OrdersProduct ordersProduct;

    @Override
    public ResponseDto save(ExportDto exportDto) {
        Optional<Orders> orders =  ordersRepository.findAllByUserId(exportDto.getUserId());
        if(orders.isEmpty()) {
            orders1.setUserId(exportDto.getUserId());
            orders1.setPayed(false);
            ordersRepository.save(orders1);
        }
        ordersProduct.setOrderId(orders.get().getId());
        ordersProduct.setProductId(exportDto.getProductId());
        ordersProduct.setAmount(exportDto.getAmount());
        ordersProductRepository.save(ordersProduct);
        return ResponseDto.builder().code(0).message("Success").success(false).build();
    }

    @Override
    public ResponseDto buy(Integer id) {
        Optional<Orders> orders = ordersRepository.findAllByUserIdAndPayed(id,false);
        if(orders.isEmpty()) {
            return ResponseDto.builder().code(-1).message("Not Found").success(false).build();
        }
        List<OrdersProduct> ordersProductList = ordersProductRepository.findAllByOrderId(orders.get().getId());
        int amount = 0;
        for(OrdersProduct ordersProduct : ordersProductList) {
            amount += ordersProduct.getAmount();
        }
        return ResponseDto.builder().code(2).message("Sotib olidi").success(true).data(amount).build();
    }
}
