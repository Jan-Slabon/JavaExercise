package com.mycompany.app;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;
public class fakestoreAPI {
    static String getData(String path){
        try {
            URL url = new URL("https://fakestoreapi.com/" + path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            final StringBuilder stringBuilder = new StringBuilder();
            reader.lines().forEach(a->stringBuilder.append(a));
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("Bad URI given!");
            return null;
        }
    }
    static public user[] getUsers(){
        ObjectMapper om = new ObjectMapper();
        String res = getData("users");
        try {
            user[] Users = om.readValue(res, user[].class);
            return Users;
        } catch (Exception e) {
            return null;
        }
        
    }
    static public cart[] getCarts(){
        ObjectMapper om = new ObjectMapper();
        String res = getData("carts");
        try {
            cart[] Carts = om.readValue(res, cart[].class);
            return Carts;
        } catch (Exception e) {
            return null;
        }
    }
    static public product[] getProducts(){
        ObjectMapper om = new ObjectMapper();
        String res = getData("products");
        try {
            product[] prod = om.readValue(res, product[].class);
            return prod;
        } catch (Exception e) {
            return null;
        }
    }

}
