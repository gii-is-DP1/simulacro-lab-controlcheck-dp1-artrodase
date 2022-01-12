package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    
    @Query("SELECT pt FROM ProductType pt")
    public List<ProductType> findAllProductTypes();
    
    /*@Query("SELECT pr FROM Product pr")
    public List<Product> getAllProducts();
    */
    
    @Query("SELECT pr from ProductType pr where pr.name = :name")
    public ProductType getProductType(@Param("name") String name);
    
    @Query("SELECT pr from Product pr where pr.price < :price")
    public List<Product> findByPriceLessThan(@Param("price") double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
