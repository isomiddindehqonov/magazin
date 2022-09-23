package imtixon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersProductDto {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer amount;
}