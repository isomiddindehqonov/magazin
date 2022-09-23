package imtixon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "product_type_seq")
    private Integer id;
    private String name;
    @Column(name = "unit_id")
    private Integer unitId;
    @Column(name = "limit_amount")
    private Integer limitAmount;
    @OneToMany(mappedBy = "typeId")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> productList;

}
