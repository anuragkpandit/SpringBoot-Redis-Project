SpringBoot with Redis
1. Dependencies: 
   - spring-boot-starter-data-redis
   - jedis
2. Entity Class
   - use @RedisHash("Product")
3. Create Config file 
   - annotate that class with 
     - @Configuration ,@EnableRedisRepositories
   - Create Bean 
     - JedisConnectionFactory(need to add port and host)
     - RedisTemplate
4. Create Repository and add methods for Crud operation
   - ex. 
   - public Product save(Product product){
     template.opsForHash().put(HASH_KEY,product.getId(),product);
     return product;
     }
5. Create controller.
6. Caching mechanism
   - @EnableChaching on controller class
   - Method level
     - @Cacheable:  
     - @CacheEvict: use for deleting record
     - @CachePut: use to put record