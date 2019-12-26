package mx.com.lobos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.com.lobos.models.Item;
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
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.finById(id, cantidad);
	}
}
