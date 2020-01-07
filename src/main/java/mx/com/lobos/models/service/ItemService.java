package mx.com.lobos.models.service;

import java.util.List;

import mx.com.lobos.models.Item;
import mx.com.lobos.models.entity.Producto;

public interface ItemService {
	
	public List<Item> finAll();
	public Item finById(Long id, Integer cantidad);
	
	public Producto save(Producto producto);
	public Producto update(Producto producto, Long id);
	public void delete(Long id);
	
}
