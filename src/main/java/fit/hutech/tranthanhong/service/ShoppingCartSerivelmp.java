package fit.hutech.tranthanhong.service;

import fit.hutech.tranthanhong.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartSerivelmp implements ShoppingCartService {
    Map<Integer, CartItem> shoppingCart = new HashMap<>();
    @Override
    public  void add(CartItem newItem){
        CartItem cartItem = shoppingCart.get(newItem.getProductId());
        if(cartItem ==  null){
            shoppingCart.put(newItem.getProductId(),newItem);

        }else{
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }
    }
    @Override
    public  void remove(int id){
        shoppingCart.remove(id);
    }

    @Override
    public CartItem update(int productId, int quantity) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public Collection<CartItem> getAllItems() {
        return null;
    }

}
