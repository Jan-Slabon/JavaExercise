package com.mycompany.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APITest {
    @Test
    public void api_test(){
        user[] res = fakestoreAPI.getUsers();
        assertTrue(res != null);

        cart[] res2 = fakestoreAPI.getCarts();
        assertTrue(res2 != null);

        product[] res3 = fakestoreAPI.getProducts();
        assertTrue(res3 != null);
    }

    @Test
    public void convert_Test(){
        String res = fakestoreAPI.getData("users");
        ObjectMapper om = new ObjectMapper();
        try {
            user[] User = om.readValue(res, user[].class);
            for(int i = 0; i < User.length; i++){
                assertFalse(User[i] == null);
            }
        } catch (Exception e) {
            System.out.println("Bad json");
            assertTrue(false);
        }
    }
    @Test
    public void users_location(){
        user[] users = fakestoreAPI.getUsers();
        user[] two_further_users = user.further_users(users);
        assertTrue(two_further_users != null);
    }
    @Test
    public void largest_cart(){
        user[] res = fakestoreAPI.getUsers();
        assertTrue(res != null);

        cart[] res2 = fakestoreAPI.getCarts();
        assertTrue(res2 != null);

        product[] res3 = fakestoreAPI.getProducts();
        assertTrue(res3 != null);

        Wrapper tmp =  cart.largest_cart_owner(res2, res3, res);
        assertTrue(tmp != null);
    }

    @Test
    public void category_value(){
        product[] res3 = fakestoreAPI.getProducts();
        assertTrue(res3 != null);

        Map<String,Double> tmp =  product.category_value(res3);
        tmp.entrySet().forEach(el -> assertTrue(el.getValue() >= 0));
    }

}
