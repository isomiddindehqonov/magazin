package imtixon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Units {
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "units_id_seq")
    @Id
    private Integer id;
    private String name;
    private Boolean payed;
}
