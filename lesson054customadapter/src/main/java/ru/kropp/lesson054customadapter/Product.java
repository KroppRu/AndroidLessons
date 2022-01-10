package ru.kropp.lesson054customadapter;

public class Product {

    String name;
    int price;
    int image;
    boolean box;

    public Product(String _describe, int _price, int _image, boolean _inbox){
        name = _describe;
        price = _price;
        image = _image;
        box = _inbox;
    }
}
