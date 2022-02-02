package com.ibis.tere;

public class ProductInfo {

    int id; // id
    String name;    // 商品名
    int price;  //　原価
    int taxedPrice; // 税込み価格

    // 与えられた情報からちゃんとしたクラスの情報を生成
    public void generate(String id, String name, String price) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.price = Integer.parseInt(price);

        // 消費税を求める
        this.taxedPrice = calcTax();

    }

    // TODO : private メソッドとは。テレーズ宿題
    private int calcTax(){

        return (int)Math.floor(this.price * (1 + getTaxRate()));

    }

    private double getTaxRate() {

        return 0.1;

    }

}
