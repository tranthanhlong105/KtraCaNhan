package fit.hutech.tranthanhong.controller;

import fit.hutech.tranthanhong.model.CartItem;
import fit.hutech.tranthanhong.model.Product;
import fit.hutech.tranthanhong.service.ProductService;
import fit.hutech.tranthanhong.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
    @RequestMapping("shoppingcart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("view")
    private  String viewCart(Model model){
        model.addAttribute("all item",shoppingCartService.getAllItems());
        model.addAttribute("totel",shoppingCartService.getAmount());
        return "view_shoppingcart";
    }
    @GetMapping("add/{id}")
    public String addItem(@PathVariable("id") Integer id){
        Product product = productService.getProductById(id);
        if(product !=null){
            CartItem item = new CartItem();
            item.setProductId(product.getId());
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(1);
            shoppingCartService.add(item);

        }
        return "redirect:/shoppingcart/view";
    }
    @GetMapping("clear")
    public String clearCart(){
        shoppingCartService.clear();
        return "redirect:/shoppingcart/view";
    }
    @GetMapping("remove/{id}")
    public String removeItem(@PathVariable("id") Integer id){
        shoppingCartService.remove(id);
        return "redirect:/shoppingcart/view";
    }
    @PostMapping("update")
    public String updatteItem(@RequestParam("productId") Integer productId,@RequestParam("quantity") Integer quantity){
        shoppingCartService.update(productId,quantity);
        return  "redirect:/shoppingcart/view";
    }

}
