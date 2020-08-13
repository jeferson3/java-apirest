package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value="Return all products")
	public List<Product> index(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value="Return unique product")
	public Product show(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}

	@PostMapping("/products")
	@ApiOperation(value="Save products")
	public Product store(@RequestBody Product product){
		return productRepository.save(product);
	}
	
	@PutMapping("/products")
	@ApiOperation(value="Update products")
	public Product update(@RequestBody Product product){
		return productRepository.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	@ApiOperation(value="Delete products")
	public void destroy(@PathVariable(value="id") long id){
		Product product = productRepository.findById(id);
		productRepository.delete(product);
	}
}
