package com.example.demo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class POItoExcel {
    public static void toExcel(List<Content> list,Boolean mark) throws FileNotFoundException, IOException{
        String text1,text2;
        text1 = "百度搜索";
        text2="E:\\\\百度搜索.xls";

        if (mark){
            text1 = "知乎热榜";
            text2="E:\\\\知乎搜索.xls";
        }

        XSSFWorkbook workBook=new XSSFWorkbook();

        XSSFSheet sheet=workBook.createSheet();

        CellRangeAddress cra=new CellRangeAddress(0,1, 0, 6);
        sheet.addMergedRegion(cra);
        Row row2=sheet.createRow(0);
        Cell cell=row2.createCell(0);
        cell.setCellValue(text1);
        CellStyle cs=workBook.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setFillBackgroundColor((short) 59);
        cell.setCellStyle(cs);


        Row row=sheet.createRow(2);
        Cell cell11=row.createCell(0);
        cell11.setCellValue("排名");
        Cell cell22=row.createCell(1);
        cell22.setCellValue("标题");
        Cell cell33=row.createCell(2);
        cell33.setCellValue("描述");



        for(int i=0;i<list.size();i++){
            XSSFRow row4=sheet.createRow(i+3);
            XSSFCell cell1=row4.createCell(0);
            XSSFCell cell2=row4.createCell(1);
            XSSFCell cell3=row4.createCell(2);


            cell1.setCellValue(list.get(i).getI());
            cell2.setCellValue(list.get(i).getTitle());
            cell3.setCellValue(list.get(i).getDesc());

        }
        workBook.write(new FileOutputStream(new File(text2)) );
        workBook.close();

    }
}