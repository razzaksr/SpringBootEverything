package boot.mvc.junit.mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class SpringBootMvcJunitMockitoApplicationTests {
	
	@MockBean
	BikeCrud crud;
	
	@Autowired
	BikeService service;
	
	/*
	 * @Test void contextLoads() { }
	 */
	
	@Test
	public void testList()
	{
		when(crud.findAll()).thenReturn(Stream.of(new Bike(1,"Avenger220",98700,45),new Bike(2,"Apache200",98900,40)).collect(Collectors.toList()));
		assertEquals(2, service.list().size());
	}
	
	@Test
	public void testOne()
	{
		when(crud.getOne(1)).thenReturn(new Bike(1,"Avenger220",98700,45));
		assertNotNull(service.getBikeById(1));
	}
	
	@Test
	public void testAdd()
	{
		Bike bike=new Bike(1,"Avenger220",98700,45);
		when(crud.save(bike)).thenReturn(bike);
		assertEquals(bike, service.newOne(bike));
	}
	
	@Test
	public void testDelete()
	{
		Bike bike=new Bike(1,"Avenger220",98700,45);
		service.delete(bike);
		verify(crud,times(1)).delete(bike);
	}

}
