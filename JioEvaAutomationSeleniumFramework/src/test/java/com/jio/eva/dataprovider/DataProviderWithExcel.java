package com.jio.eva.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderWithExcel {

	String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx";
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	@DataProvider
	public Object[][] getData() throws IOException {
		System.out.println("@DataProvider");
		fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet("Login");

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		Object[][] dataObject = new Object[rowCount][1];
		for (int row = 0; row < rowCount; row++) {
			HashMap<String, String> data = new HashMap<>();
			for (int col = 0; col < columnCount; col++) {
				String key = sheet.getRow(0).getCell(col).getStringCellValue();
				String value = sheet.getRow(row + 1).getCell(col).getStringCellValue();
				data.put(key, value);
			}
			dataObject[row][0] = data;
		}
		workbook.close();
		return dataObject;
	}


	public List<Map<String, Object>> getRunnerData(){
System.out.println("getRunnerData()");
		List<Map<String,Object>> list = new ArrayList<>();
		try {
			fis = new FileInputStream(excelPath);

			workbook = new XSSFWorkbook(fis);

			sheet = workbook.getSheet("RunManager");

			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();


			for (int row = 0; row < rowCount; row++) {
				Map<String, Object> data = new HashMap<>();
				for (int col = 0; col < columnCount; col++) {
					String key = sheet.getRow(0).getCell(col).getStringCellValue();
					String value = sheet.getRow(row + 1).getCell(col).getStringCellValue();
					data.put(key, value);
				}
				list.add(data);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
