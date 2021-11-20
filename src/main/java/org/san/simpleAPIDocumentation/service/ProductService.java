package org.san.simpleAPIDocumentation.service;

import java.util.Collection;

import org.san.simpleAPIDocumentation.dao.Dao;
import org.san.simpleAPIDocumentation.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	public Dao<Product> productDao;

	public Product byId(Long id) {
		return productDao.read(id);
	}

	public void create(Product product) {
		productDao.create(product);
		;
	}

	public Collection<Product> all() {
		return productDao.all();
	}
}
