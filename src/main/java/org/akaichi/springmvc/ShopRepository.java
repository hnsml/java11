package org.akaichi.springmvc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

    Shop save(Shop shop);
    Optional<Shop> findById(Long id);
    void deleteById(Long id);
    List<Shop> findAll();
}
