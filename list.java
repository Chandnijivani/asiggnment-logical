
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mtech
 */
public class list {
    
    public List<city> readcityFromExcelFile(String excelFilePath) throws IOException {
    List<city> listcity = new ArrayList<>();
    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
 
    Workbook workbook = new XSSFWorkbook(inputStream);
    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();
 
    while (iterator.hasNext()) {
        Row nextRow = iterator.next();
        
       
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        city acity = new city();
 
        while (cellIterator.hasNext()) {
            Cell nextCell = cellIterator.next();
            int columnIndex = nextCell.getColumnIndex();
 
            switch (columnIndex) {
            case 0:
                acity.setCompany(nextCell.getStringCellValue());
                break;
            case 1:
                acity.setFrom( nextCell.getStringCellValue());
                break;
            case 2:
            
                acity.setTo( nextCell.getStringCellValue());
                break;
                
           case 3:
              
              acity.setFare(nextCell.getNumericCellValue());
               
                break;
           case 4:
                acity.setTime(nextCell.getNumericCellValue());
                break;
            }
 
 
         
            
        }
        listcity.add(acity);
        
    }
 
    workbook.close();
    inputStream.close();
 
    return listcity;
}
    
    
    
    public static void main(String[] args) throws IOException {
    String excelFilePath = "/home/mtech/NetBeansProjects/WebApplication4/src/java/sheet3.xlsx";
    list reader = new list();
    List<city> listcity = reader.readcityFromExcelFile(excelFilePath);
    for(int i=0;i<listcity.size();i++)
    {
        System.out.println(listcity.get(i).getCompany()+" "+listcity.get(i).getFrom()+" "+listcity.get(i).getFrom()+" "+listcity.get(i).getTo()+" "+listcity.get(i).getFare()+" "+listcity.get(i).getTime());
    }
   
   
}
    
}
