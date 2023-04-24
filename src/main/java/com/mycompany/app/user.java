package com.mycompany.app;
import com.fasterxml.jackson.annotation.JsonProperty;




class Address{
    public Geolocation geolocation;
    public String city;
    public String street;
    public int number;
    public String zipcode;
    @Override
    public String toString() {
        return "Address [geolocation=" + geolocation + ", city=" + city + ", street=" + street + ", number=" + number
                + ", zipcode=" + zipcode + "]";
    }
}

class Geolocation{
    public String lat;
    @JsonProperty("long") 
    public String mylong;
    @Override
    public String toString() {
        return "Geolocation [lat=" + lat + ", mylong=" + mylong + "]";
    }
}

class Name{
    public String firstname;
    public String lastname;
    @Override
    public String toString() {
        return "Name [firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}

public class user{
    public Address address;
    public int id;
    public String email;
    public String username;
    public String password;
    public Name name;
    public String phone;
    public int __v;
    @Override
    public String toString() {
        return "user [address=" + address + ", id=" + id + ", email=" + email + ", username=" + username + ", password="
                + password + ", name=" + name + ", phone=" + phone + ", __v=" + __v + "]";
    }
    static float calculate_distance(user us1, user us2){
        float x1 = Float.parseFloat(us1.address.geolocation.lat); 
        float x2 = Float.parseFloat(us2.address.geolocation.lat); 
        float y1 = Float.parseFloat(us1.address.geolocation.mylong); 
        float y2 = Float.parseFloat(us2.address.geolocation.mylong); 
        return (float) Math.sqrt ( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    static public user[] further_users(user[] users){
        if(users == null) return null;
        if(users.length == 1) return null;
        user us1 = users[0];
        user us2 = users[1];
        float tmp_distance = calculate_distance(us1, us2);
        for(user usr : users){
            for(user usr2 : users){
                if(calculate_distance(usr, usr2) > tmp_distance){
                    tmp_distance = calculate_distance(usr, usr2);
                    us1 = usr; us2 = usr2;
                }
            }
        }
        // System.out.println(tmp_distance);
        user[] result = {us1, us2};
        return result;
    }
    static public user find_user_by_id(user[] users, int id){
        if(users == null) return null;
        for(user us : users){
            if (us.id == id) return us;
        }
        return null;
    }
}





