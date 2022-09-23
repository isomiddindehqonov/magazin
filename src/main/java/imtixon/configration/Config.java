package imtixon.configration;

import imtixon.entity.Orders;
import imtixon.entity.OrdersProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Orders toOrders(){
        return  new Orders();
    }
    @Bean
    public OrdersProduct toOrdersProduct(){
        return new OrdersProduct();
    }
}
