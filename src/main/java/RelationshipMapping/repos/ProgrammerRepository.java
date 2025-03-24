package RelationshipMapping.repos;

import RelationshipMapping.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
}
