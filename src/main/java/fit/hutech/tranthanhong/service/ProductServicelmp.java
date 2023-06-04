package fit.hutech.tranthanhong.service;

import fit.hutech.tranthanhong.model.Product;
import fit.hutech.tranthanhong.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//import fit.hutech.tranthanhong.model.Product;
//import fit.hutech.tranthanhong.repository.ProductRepository;
import java.util.Optional;

import java.util.List;
import java.util.Optional;
@Component
@Repository
@Service
public class ProductServicelmp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }
    @Override
    public  void saveProduct(Product product){
        this.productRepository.save(product);
    }
    @Override
    public Product getProductById(int id){
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Product for id::"+id);

        }
        return product;
    }
    @Override
    public void deleteProductById(int id){
        this.productRepository.deleteById(id);
    }
}
