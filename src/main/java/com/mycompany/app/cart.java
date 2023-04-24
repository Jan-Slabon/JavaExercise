package com.mycompany.app;
import java.util.ArrayList;
import java.util.Date;
class Prod{
    public int productId;
    public int quantity;
}
class Wrapper{
    public cart high_cart;
    public double value;
    public user high_user;
    @Override
    public String toString() {
        return "Wrapper [high_cart=" + high_cart + ", value=" + value + ", high_user=" + high_user + "]";
    }
}
public class cart{
    public int id;
    public int userId;
    public Date date;
    public ArrayList<Prod> products;
    public int __v;

    static public double calcualte_value(cart target, product[] prod){
        double tmp = 0;
        for(Prod el : target.products){
            tmp += el.quantity * product.find_by_id(prod, el.productId).price;
        }
        return tmp;
    }

    static public cart largest_cart(cart[] carts, product[] prod){
        if(carts == null) return null;
        cart tmp = carts[0];
        double tmp_val = cart.calcualte_value(tmp, prod);
        for(cart el : carts){
            if (cart.calcualte_value(el, prod) > tmp_val){
                tmp_val = cart.calcualte_value(el, prod);
                tmp = el;
            }
        }
        return tmp;
    }
    
    static public Wrapper largest_cart_owner(cart[] carts, product[] prod, user[] users){
        cart tmp_cart = cart.largest_cart(carts, prod);
        user tmp_user = user.find_user_by_id(users, tmp_cart.userId);
        Wrapper wrap = new Wrapper();
        wrap.high_cart = tmp_cart;
        wrap.high_user = tmp_user;
        wrap.value = cart.calcualte_value(tmp_cart, prod);
        return wrap;
    }
}

