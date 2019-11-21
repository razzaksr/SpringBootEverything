package boot.mvc.junit.mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class BikeService 
{
	@Autowired
	BikeCrud crud;
	
	public List<Bike> list()
	{
		List<Bike> bikes=crud.findAll();
		return bikes;
	}
	
	public Optional<Bike> getBikeById(int id)
	{
		return crud.findById(id);
	}
	
	public Bike newOne(Bike bike)
	{
		crud.save(bike);
		return bike;
	}
	
	public void delete(Bike bike)
	{
		crud.delete(bike);
	}
	
	public Bike update(Bike bike)
	{
		return crud.save(bike);
	}
}
