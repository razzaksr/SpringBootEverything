package boot.mvc.junit.mockito;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeRest 
{
	@Autowired
	BikeService serv;
	@GetMapping("/list")
	public List<Bike> list()
	{
		return serv.list();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Bike> getOne(@PathVariable("id") int id)
	{
		return serv.getBikeById(id);
	}
	
	@PostMapping("/new")
	public Bike insert(@RequestBody Bike bike)
	{
		return serv.newOne(bike);
	}
	
	@PutMapping("/alter")
	public Bike update(@RequestBody Bike bike)
	{
		return serv.update(bike);
	}
	
	@DeleteMapping("/remove")
	public void remove(@RequestBody Bike bike)
	{
		serv.delete(bike);
	}
}
