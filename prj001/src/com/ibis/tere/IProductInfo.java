package com.ibis.tere;

public interface IProductInfo {
    void generate(String id, String name, String price);

    int getId();
    String getName();
    int getPrice();
    int getTaxedPrice();

}
