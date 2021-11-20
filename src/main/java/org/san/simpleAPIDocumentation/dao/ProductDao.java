package org.san.simpleAPIDocumentation.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.san.simpleAPIDocumentation.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDao implements Dao<Product> {

	private static final Map<Long, Product> PRODUCTS = new ConcurrentHashMap<>();

	static {
		PRODUCTS.put(1L, new Product(1L, "Test"));
	}

	@Override
	public void create(Product ob) {
		PRODUCTS.put(ob.getId(), ob);
	}

	@Override
	public Product read(Long id) {
		return PRODUCTS.get(id);
	}

	@Override
	public void update(Product bo) {
		PRODUCTS.replace(bo.getId(), bo);

	}

	@Override
	public void delete(Long id) {
		PRODUCTS.remove(id);
	}

	@Override
	public Collection<Product> all() {
		return PRODUCTS.values();
	}

}
