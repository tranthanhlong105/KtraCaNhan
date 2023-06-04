package fit.hutech.tranthanhong.service;
import fit.hutech.tranthanhong.model.Product;
import org.springframework.stereotype.Service;
//import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
}
