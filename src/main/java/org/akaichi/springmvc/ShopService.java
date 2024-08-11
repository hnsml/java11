package org.akaichi.springmvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public void saveShop(Shop shop) {
        shopRepository.save(shop);
    }

    public Optional<Shop> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    public void delete(Long id) { shopRepository.deleteById(id);}

    public List<Shop> searchUsers(String input) {
        List<Shop> shops = getAllShops();
        ArrayList<Shop> result = new ArrayList<>();
        for(Shop shop : shops)
        {
            if(shop.getName().contains(input) || shop.getAddress().contains(input) || shop.getEmail().contains(input) || shop.getCategory().contains(input) || shop.getDescription().contains(input) || shop.getNumber().contains(input) || shop.getUrl().contains(input))
            {
                result.add(shop);
            }
        }
        return result;
    }
}
