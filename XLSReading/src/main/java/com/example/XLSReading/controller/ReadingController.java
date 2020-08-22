package com.example.XLSReading.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.XLSReading.entity.PinCodeEntity;
import com.example.XLSReading.entity.PinCodeRepository;

@RestController
@RequestMapping("/users")
public class ReadingController {
	@Autowired
	PinCodeRepository pinCodeRepository;
	@GetMapping("/statusCheck")
	public String Status() throws IOException {
		readData();
		return "success";
	}
	
	private void readData() throws IOException {
		//obtaining input bytes from a file  
		FileInputStream fis=new FileInputStream(new File("/home/nineleaps/Desktop/aspire/pincode_master_final.xls"));  
		//FileInputStream fis=new FileInputStream(new File("D:\\aspire\\pincode_master_final.xls"));  
		
		//creating workbook instance that refers to .xls file  
		HSSFWorkbook wb=new HSSFWorkbook(fis);   
		//creating a Sheet object to retrieve the object  
		HSSFSheet sheet=wb.getSheetAt(0);  
		//evaluating cell type   
		FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
		for(Row row: sheet)     //iteration over row using for each loop  
		{
		if(row.getRowNum()==0) continue;
		StringBuilder sb=new StringBuilder();	
		for(Cell cell: row)    //iteration over cell using for each loop  
		{  
		switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
		{  
		case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
		//getting the value of the cell as a number
			sb.append("MMMM");
			sb.append(cell.getNumericCellValue()+"&&&&");
		//System.out.print(cell.getNumericCellValue()+ "\t\t");   
		break;  
		case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
		//getting the value of the cell as a string
			sb.append("MMMM");
			sb.append(cell.getStringCellValue()+"&&&&");
		//System.out.print(cell.getStringCellValue()+ "\t\t");  
		break;  
		case Cell.CELL_TYPE_BLANK:
			sb.append("MMMM");
			sb.append(cell.getStringCellValue()+"&&&&");
			break;
		}  
		}
		String[] val=sb.toString().split("&&&&");
		if(val[0].equals("MMMM110079.0")) {
			System.out.println("vals are blank");
		}
		PinCodeEntity pinCodeEntity=new PinCodeEntity();
		//for(int i=0;i<val.length;i++) {
			//PinCodeEntity pinCodeEntity=new PinCodeEntity();
			if(val[0].equals("MMMM"))
			    pinCodeEntity.setPinCode("");
			else {
				String pinCode=val[0].trim().substring(4);
				double dPin=Double.parseDouble(pinCode);
				int intPin=(int)dPin;
				pinCodeEntity.setPinCode(String.valueOf(intPin));
			}
			if(val[1].equals("MMMM"))
				pinCodeEntity.setCity("");
			else {
				String city=val[1].trim().substring(4);
				pinCodeEntity.setCity(city);
			}
			if(val[2].equals("MMMM"))
				pinCodeEntity.setDivision("");
			else {
				String division=val[2].trim().substring(4);
				pinCodeEntity.setDivision(division);
			}
			if(val[3].equals("MMMM"))
				pinCodeEntity.setRegion("");
			else {
				String region=val[3].trim().substring(4);
				pinCodeEntity.setRegion(region);
			}
			if(val[4].equals("MMMM"))
				pinCodeEntity.setTaluk("");
			else {
				String taluk=val[4].trim().substring(4);
				pinCodeEntity.setTaluk(taluk);
			}
			if(val[5].equals("MMMM"))
				pinCodeEntity.setDistrict("");
			else {
				String district=val[5].trim().substring(4);
				pinCodeEntity.setDistrict(district);
			}
			if(val[6].equals("MMMM"))
				pinCodeEntity.setState("");
			else {
				String state=val[6].trim().substring(4);
				pinCodeEntity.setState(state);
			}
			if(val[7].equals("MMMM"))
				pinCodeEntity.setStateAddr("");
			else {
				String stateAddr=val[7].trim().substring(4);
				pinCodeEntity.setStateAddr(stateAddr);
			}
			
			
			
			
			//pinCodeEntity.setStateAddr(val[7].trim());
			//String isEligible=val[8];
			//long longEligible=(Long)Long.parseLong(isEligible.trim());
			pinCodeEntity.setIsEligible(1);
		//}
			pinCodeRepository.save(pinCodeEntity);
		System.out.println(sb.toString());
		System.out.println();  
		}  
		  
	}
}
