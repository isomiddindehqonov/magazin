package imtixon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "orders_id_seq")
    @Id
    private Integer id;
    private Integer userId;
    private Boolean payed;
    @OneToMany(mappedBy = "orderId")
    private List<OrdersProduct> ordersProductList;
}

