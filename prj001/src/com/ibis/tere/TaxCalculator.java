package com.ibis.tere;

import java.io.*;
import java.util.ArrayList;

public class TaxCalculator {

    boolean isHorizonView = true;   // 出力を横並びで出力する場合 true を設定する。縦に並べる場合は false。
    String filePath;  // CSVが存在する位置のファイルパス
    ICreator iCreator;

    ArrayList<IProductInfo> infos = null;    // 商品情報コレクションを用意しますよ

    // 計算処理の事前準備部分
    public boolean init(boolean isHorizonView, String filePath, ICreator iCreator) {

        // いろいろ初期処理を行う。
        this.isHorizonView = isHorizonView;
        this.filePath = filePath;

        this.iCreator = iCreator;

        // 成功したら true、失敗したらfalseを返却する。
        return true;

    }

    // 計算処理の本処理部分
    public void execute() throws FileNotFoundException{

        // CSV 読み込み + 商品情報クラスを生成する。
        this.infos = this.iCreator.create(this.filePath);

    }

    public String getDetailStrH(ArrayList<IProductInfo> information) {
        // 出力する : id, name, price, taxedPrice の順。

        // 返却用のStringを用意
        String retStr = "";

        // 返却用文字列の生成。
        for (IProductInfo info : information) {
            // 一つのデータを横並びにして、改行して書いていく
            retStr += "id:" + info.getId() + ",name:" + info.getName() + ",price:" + info.getPrice() + ",taxedPrice:" + info.getTaxedPrice() + "\r\n";
        }

        return retStr;

    }

    public String getDetailStrV(ArrayList<IProductInfo> information) {
        // 出力する2 : id, name, price, taxedPriceを 全部の要素を縦に出力する。

        // 返却用のStringを用意
        String retStr = "";

        // 返却用文字列の生成。全部縦にする。
        for (IProductInfo info : information) {
            retStr += "id:" + info.getId() + "\r\n";
            retStr += "name:" + info.getName() + "\r\n";
            retStr += "price:" + info.getPrice() + "\r\n";
            retStr += "taxedPrice:" + info.getTaxedPrice() + "\r\n";
            retStr += "------------\r\n";
        }
        return retStr;
    }

    // 出力用文字列取得
    public String getDisplayStr(ArrayList<IProductInfo> infos, boolean isHorizonView) {
        return isHorizonView ? getDetailStrH(infos) : getDetailStrV(infos);
    }

    // 計算処理の終了処理
    public void finish() {

        // 出力用文字列取得
        String str = this.getDisplayStr(this.infos,this.isHorizonView);
        // 出力
        System.out.println(str);

    }

}
