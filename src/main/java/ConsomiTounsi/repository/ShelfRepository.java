package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.entities.typeShelf;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Long> {
	
	 /*List<Shelf> FindByTypeShelf(typeShelf type);*/


	@Query(value="SELECT s FROM Shelf s WHERE s.typeShelf = type",nativeQuery = true)
	List<Shelf> FindByTypeShelf(typeShelf type);



}
