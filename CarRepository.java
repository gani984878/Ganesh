// src/main/java/com/ganicar/carinventory/CarRepository.java
package com.ganicar.carinventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMakeIgnoreCase(String make);
    List<Car> findByColor(String color);

    @Query("SELECT c FROM Car c WHERE (:make IS NULL OR LOWER(c.make) = LOWER(:make)) " +
            "AND (:minPrice IS NULL OR c.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR c.price <= :maxPrice)")
    Page<Car> findAllByMakeAndPrice(@Param("make") String make,
                                    @Param("minPrice") Double minPrice,
                                    @Param("maxPrice") Double maxPrice,
                                    Pageable pageable);
}