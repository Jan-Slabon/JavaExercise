package com.mycompany.app;
import java.util.HashMap;
import java.util.Map;
class Rating{
    public double rate;
    public int count;
}

public class product{
    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public Rating rating;

    static public product find_by_id(product[] list, int id){
        for(product el : list){
            if (el.id == id) return el;
        }
        return null;
    }
    // we are assuming the list of products doesnt have duplicates
    public static Map<String, Double> category_value(product[] list){
        if(list == null) return null;
        Map<String, Double> value_map = new HashMap<>();
        for(product el : list){
            if (value_map.containsKey(el.category)){
                value_map.replace(el.category, value_map.get(el.category) + el.price);
            }else{
                value_map.put(el.category, 0.);
            }
        }
        return value_map;
    }
}

