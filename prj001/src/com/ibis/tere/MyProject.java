package com.ibis.tere;

import java.io.FileNotFoundException;

public class MyProject {

    public static void main(String[] args) {

        // 税込み価格計算クラスを開始
        TaxCalculator prj = new TaxCalculator();

        boolean ret = prj.init(true, "C:\\omyGit\\prj001\\resouces\\aaa.csv"); // 処理準備

        // ガード節
        if (!ret) {
            // 準備段階で失敗。処理終了
            System.out.println("初期処理に失敗したので終了します。");
            return ;
        }

        try {
            prj.execute();  // 処理実行
        } catch ( FileNotFoundException e) {
            System.out.println("なかったんかぁ。わかった。");

        }

        prj.finish();   // 終了処理

    }

}
