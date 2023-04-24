package com.mycompany.app;

import java.util.Map;

public class Main {
    public static void main(String[] args){
        user[] res = fakestoreAPI.getUsers();
       
        cart[] res2 = fakestoreAPI.getCarts();

        product[] res3 = fakestoreAPI.getProducts();

        user[] two_further_users = user.further_users(res);
        System.out.println(two_further_users[0].toString());
        System.out.println(two_further_users[1].toString());


        Wrapper tmp =  cart.largest_cart_owner(res2, res3, res);
        System.out.println(tmp);


        Map<String,Double> tmp2 =  product.category_value(res3);
        tmp2.entrySet().forEach(el -> System.out.println(el.getKey() + " " + el.getValue()));
        
    } 
    
}
