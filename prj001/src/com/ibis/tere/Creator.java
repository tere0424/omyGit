package com.ibis.tere;

import java.io.*;
import java.util.ArrayList;

public class Creator implements ICreator {

    @Override
    public ArrayList<IProductInfo> create( String filePath ) {

        ArrayList<IProductInfo> information = new ArrayList<>();    // 商品情報コレクションを用意しますよ
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
                IProductInfo info = new ProductInfo();
                info.generate(strArray[0], strArray[1], strArray[2]);

                // 生成した商品情報クラスを保存
                information.add(info);

            }
        } catch (FileNotFoundException e) {
            // なんかエラー。ファイル
            System.out.println("指定のファイルパスにファイルがありませんよ");
        } catch (IOException e) {
            //　存在しているけど、読み込みできませんでした。
            System.out.println("存在しているけど、読み込みできませんでした。");
        } catch (Exception e) {
            // 他なんかエラー。不明
            System.out.println("なんかエラーが出ました。不明です。");
            System.out.println(e.getMessage());
        }

        return information;
    }
}
