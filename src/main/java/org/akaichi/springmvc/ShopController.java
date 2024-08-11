package org.akaichi.springmvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/all")
    public String getAllShops(@RequestParam(value = "search", required = false) String search, Model model) {
        if(search != null && !search.isEmpty())
        {
            model.addAttribute("shop_list", shopService.searchUsers(search));
        }
        else
        {
            model.addAttribute("shop_list", shopService.getAllShops());
        }
        return "shops";
    }

    @GetMapping("/add")
    public String createForm(Model model) {
        model.addAttribute("shop", new Shop());
        return "add";
    }

    @PostMapping("/shop")
    public String shopFormSubmit(@ModelAttribute Shop shop, Model model) {
        model.addAttribute("shop", shop);
        shopService.saveShop(shop);
        return "redirect:/shops/all";
    }

    @GetMapping("/details")
    public String details(Model model, Long id) {
        Optional<Shop> shop = shopService.getShopById(id);
        model.addAttribute("shop", shop);
        return "details";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam Long id, Model model) {
        Optional<Shop> shop = shopService.getShopById(id);
        shop.ifPresent(value -> model.addAttribute("shop", value));
        return "edit";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam Long id, Model model) {
        shopService.delete(id);
        return "redirect:/shops/all";
    }
}
