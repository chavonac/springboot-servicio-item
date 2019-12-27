package mx.com.lobos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.com.lobos.models.Item;
import mx.com.lobos.models.Producto;
import mx.com.lobos.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
//	@Qualifier("serviceFeign")
	@Qualifier("serviceRestTemplate")
	
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.finAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.finById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Camara Sony");
		producto.setPrecio(545.45);
		item.setProducto(producto);
		return item;
	}
}
