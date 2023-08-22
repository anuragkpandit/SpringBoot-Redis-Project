package com.springBootRedisProject.Controller;

import com.springBootRedisProject.Entity.Product;
import com.springBootRedisProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
@RequestMapping("/product")
public class RedisController {

    private ProductRepo productRepo;

    public RedisController(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping
    private List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product getProductById(@PathVariable int id){
        return productRepo.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return productRepo.deleteProduct(id);
    }
}
