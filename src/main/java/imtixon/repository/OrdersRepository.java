package imtixon.repository;

import imtixon.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Optional<Orders> findAllByUserId(Integer id);
    Optional<Orders> findAllByUserIdAndPayed(Integer id, boolean boll);
}