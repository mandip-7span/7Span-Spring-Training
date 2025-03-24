package InheritanceMapping.InheritanceMapping.repos;

import InheritanceMapping.InheritanceMapping.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
