package org.san.simpleAPIDocumentation.resource;

import java.util.Collection;

import org.san.simpleAPIDocumentation.entity.Product;
import org.san.simpleAPIDocumentation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductsResource {

	@Autowired
	public ProductService productService;
	
	@Operation(summary = "Get all the products")
	@GetMapping
	public Collection<Product> products(){
		return productService.all();
	}
	
	@Operation(summary = "Get a product by given id")
	@GetMapping("/{id}")
	public Product byId(@PathVariable("id") Long id){
		return productService.byId(id);
	}
	
	@Operation(summary = "Create a new product")
	@PostMapping("/create")
	public void create(@RequestBody Product product){
		productService.create(product);
	}
}
