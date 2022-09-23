package imtixon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersProduct {
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ordersProduct_id_seq")
    @Id
    private Integer id;
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id",insertable = false, updatable = false)
    private Integer productId;
    private Integer amount;

    @ManyToOne
    private Product product;
}
