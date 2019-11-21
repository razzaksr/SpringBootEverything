package boot.mvc.junit.mockito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeCrud extends JpaRepository<Bike, Integer>{
	
}
