package fit.hutech.tranthanhong.repository;

import fit.hutech.tranthanhong.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {
    //Page<Product> findAll(Pageable pageable);

}
