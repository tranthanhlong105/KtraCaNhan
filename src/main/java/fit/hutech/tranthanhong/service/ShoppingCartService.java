package fit.hutech.tranthanhong.service;
import java.util.Collection;
import fit.hutech.tranthanhong.model.CartItem;

public interface  ShoppingCartService {
    void add(CartItem newItem);

    void remove(int id);

    CartItem update(int productId,int quantity);
    void clear();
    double getAmount();
    Collection<CartItem> getAllItems();

}
