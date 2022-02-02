package com.ibis.tere;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void init() {
    }

    @Test
    void execute() {
    }

    @Test
    void generateProductInfoWithCSV01() throws FileNotFoundException {
        TaxCalculator obj = new TaxCalculator();
        ArrayList<ProductInfo> infos = obj.generateProductInfoWithCSV("C:\\omyGit\\prj001\\resouces\\aaa.csv");

        // 検証その1 : 件数が一致すること
        assertEquals(5, infos.size());

        // 検証その２ : 内容に過不足がないこと
        ProductInfo info = infos.get(0);
        assertEquals(1, info.id);
        assertEquals("maguro", info.name);
        assertEquals(500, info.price);
        assertEquals(550, info.taxedPrice);

        // 繰り返し5件
        info = infos.get(1);
        assertEquals(2, info.id);
        assertEquals("saba", info.name);
        assertEquals(400, info.price);
        assertEquals(440, info.taxedPrice);

    }

    @Test
    void displayProductInfo() {
    }

    @Test
    void finish() {
    }
}