package boot.mvc.junit.mockito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController 
{
	@Autowired
	BikeService serve;
	@RequestMapping("/")
	public ModelAndView list()
	{
		ModelAndView mod=new ModelAndView("list");
		List<Bike> bikes=serve.list();
		return mod.addObject("all", bikes);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add()
	{
		return new ModelAndView("create");
	}
	@RequestMapping(value="/created",method=RequestMethod.POST)
	public ModelAndView added(Bike bike)
	{
		serve.newOne(bike);
		return new ModelAndView("created");
	}
	@RequestMapping(value="/fetch",method=RequestMethod.GET)
	public ModelAndView get()
	{
		return new ModelAndView("fetch");
	}
	@RequestMapping(value="/fetched",method=RequestMethod.POST)
	public ModelAndView got(@RequestParam("bid") int bid)
	{
		Bike bike=serve.getBikeById(bid).orElse(new Bike());
		// return data if exists otherwise return empty bike with default initialisation
		return new ModelAndView("fetched").addObject("bike",bike);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView modify()// select bike by id to update
	{
		return new ModelAndView("update");
	}
	@RequestMapping(value="/letupdate",method=RequestMethod.POST)
	public ModelAndView modifying(@RequestParam("bid") int bid)//once id selected show detail which let user to update
	{
		Bike bike=serve.getBikeById(bid).orElse(new Bike());
		// return data if exists otherwise return empty bike with default initialisation
		return new ModelAndView("letupdate").addObject("bike",bike);
	}
	@RequestMapping(value="/updated",method=RequestMethod.POST)
	public ModelAndView modified(Bike bike)//once changes here updating row in table
	{
		serve.update(bike);
		return new ModelAndView("updated").addObject("bike",bike);
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView remove()
	{
		return new ModelAndView("delete");
	}
	@RequestMapping(value="/deleted",method=RequestMethod.POST)
	public ModelAndView removed(@RequestParam("bid") int bid)
	{
		Bike bike=serve.getBikeById(bid).orElse(new Bike());
		serve.delete(bike);
		// return data if exists otherwise return empty bike with default initialisation
		return new ModelAndView("deleted").addObject("bike",bike);
	}
}
