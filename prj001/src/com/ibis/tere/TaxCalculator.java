package com.ibis.tere;

import java.io.*;
import java.util.ArrayList;

public class TaxCalculator {

    boolean isHorizonView = true;   // 出力を横並びで出力する場合 true を設定する。縦に並べる場合は false。
    String filePath;  // CSVが存在する位置のファイルパス

    ArrayList<ProductInfo> infos = null;    // 商品情報コレクションを用意しますよ

    // 計算処理の事前準備部分
    public boolean init(boolean isHorizonView, String filePath) {

        // いろいろ初期処理を行う。
        this.isHorizonView = isHorizonView;
        this.filePath = filePath;

        // 成功したら true、失敗したらfalseを返却する。
        return true;

    }

    // 計算処理の本処理部分
    public void execute() throws FileNotFoundException{

        // CSV 読み込み + 商品情報クラスを生成する。
        this.infos = this.generateProductInfoWithCSV(this.filePath);

    }

    // CSV 読み込み + 商品情報クラスを生成する。
    public ArrayList<ProductInfo> generateProductInfoWithCSV(String filePath) throws FileNotFoundException {

        ArrayList<ProductInfo> infos = new ArrayList<>();    // 商品情報コレクションを用意しますよ
        try {
            // ファイル読み込み
            FileInputStream stream = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);

            String line;

            // 一行読み込み : 最終行で読み込めない場合は終了する。（nullで終了）
            while ((line = br.readLine()) != null) {

                // 読み込んだ一行を配列で格納する。
                String[] strArray = line.split(",");

                // ただの文字情報を、商品情報クラスとしてひとつ生成
                ProductInfo info = new ProductInfo();
                info.generate(strArray[0], strArray[1], strArray[2]);

                // 生成した商品情報クラスを保存
                infos.add(info);

            }
        } catch (FileNotFoundException e) {
            // なんかエラー。ファイル
            System.out.println("指定のファイルパスにファイルがありませんよ");
            throw e;
        } catch (IOException e) {
            //　存在しているけど、読み込みできませんでした。
            System.out.println("存在しているけど、読み込みできませんでした。");
        } catch (Exception e) {
            // 他なんかエラー。不明
            System.out.println("なんかエラーが出ました。不明です。");
            System.out.println(e.getMessage());
        }

        return infos;
    }

    public String getDetailStrH(ArrayList<ProductInfo> infos) {
        // 出力する : id, name, price, taxedPrice の順。

        // 返却用のStringを用意
        String retStr = "";

        // 返却用文字列の生成。
        for (ProductInfo info : infos) {
            // 一つのデータを横並びにして、改行して書いていく
            retStr += "id:" + info.id + ",name:" + info.name + ",price:" + info.price + ",taxedPrice:" + info.taxedPrice+ "\r\n";
        }

        return retStr;

    }

    public String getDetailStrV(ArrayList<ProductInfo> infos) {
        // 出力する2 : id, name, price, taxedPriceを 全部の要素を縦に出力する。

        // 返却用のStringを用意
        String retStr = "";

        // 返却用文字列の生成。全部縦にする。
        for (ProductInfo info : infos) {
            retStr += "id:" + info.id + "\r\n";
            retStr += "name:" + info.name + "\r\n";
            retStr += "price:" + info.price + "\r\n";
            retStr += "taxedPrice:" + info.taxedPrice + "\r\n";
            retStr += "------------\r\n";
        }
        return retStr;
    }

    // 出力用文字列取得
    public String getDisplayStr(ArrayList<ProductInfo> infos, boolean isHorizonView) {
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
