package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
