package com.unistore.server.repositories;

import com.unistore.server.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * from product where Name = :name", nativeQuery = true)
    List<Product> findByNamee(@Param("name") String name);

    @Query(value = "SELECT * from Product ", nativeQuery = true)
    List<Product> findAllProduct();


    // show product by search, query, page, limit
    @Query(value = "SELECT * from  product " +
                        "WHERE lower(Name) like %:search% " +
                        "AND lower(Catalog) like %:catalog% " +
                        "AND lower(Processer) like %:processer% " +
                        "AND lower(HardDrive) like %:hardDrive% " +
                        "LIMIT :offset , :limit", nativeQuery = true)
    List<Product> findByPage(@Param("limit") int limit,
                             @Param("offset") int offset,
                             @Param("search") String search,
                             @Param("catalog") String catalog,
                             @Param("processer") String processer,
                             @Param("hardDrive") String hardDrive
                            );

    // show all products by search, query
    @Query(value = "SELECT * from  product " +
                        "WHERE lower(Name) like %:search% " +
                        "AND lower(Catalog) like %:catalog% " +
                        "AND lower(Processer) like %:processer% " +
                        "AND lower(HardDrive) like %:hardDrive% ", nativeQuery = true)
    List<Product> findByQuery(@Param("search") String search,
                                @Param("catalog") String catalog,
                                @Param("processer") String processer,
                                @Param("hardDrive") String hardDrive
                            );
}
