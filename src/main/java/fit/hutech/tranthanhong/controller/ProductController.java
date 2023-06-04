package fit.hutech.tranthanhong.controller;

//import ch.qos.logback.core.model.Model;
import fit.hutech.tranthanhong.model.Product;
import org.springframework.ui.Model;
import fit.hutech.tranthanhong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("view")
    public String viewProduct(Model model){
        model.addAttribute("listProducts",productService.getAllProducts());
        return "view_productlist";
    }

    @GetMapping("addnew")
    public String showNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }

    @PostMapping("save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/view";
        //return "view_shoppingcart";
        //return "redirect:/shoppingcart/view";
    }




}
