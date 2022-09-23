package imtixon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "product_id_seq")
    @Id
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    @Column(name = "type_id")
    private Integer typeId;
}
