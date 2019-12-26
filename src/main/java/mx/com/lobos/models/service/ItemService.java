package mx.com.lobos.models.service;

import java.util.List;

import mx.com.lobos.models.Item;

public interface ItemService {
	
	public List<Item> finAll();
	public Item finById(Long id, Integer cantidad);
}
