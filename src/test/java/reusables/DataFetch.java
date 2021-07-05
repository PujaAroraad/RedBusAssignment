package reusables;

import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DataFetch {
	
	//the concept used is:
	//tr refers to titke row and r refers to any of data rows 
	//by default actual status is set to value "fail"
	//if the test is selected as it should run "run" value in xlsx file and the test case successfully pass then actual status is set to "pass"
	//if the test is selected as it should not run "not run" value in xlsx file then the actual status is set to "not defined"
	//if the test case fails....the code breaks in middle and default value of actual status is considered i.e. "fail" 
	//refer to any test code that requires file access for above conditions 
	
	
	
	//get the column index of actual status as this value is to be updated by code. thus index needed.
	public int getStatusColumn(Row tr) {
		int status=0;
		for(int i=0;i<tr.getLastCellNum();i++) {
			if (tr.getCell(i).getStringCellValue().equals("Actual Status")) {
				status = i;
				break;
			}
		}	
		return status;
	}
	
	//setting the default value of actual status column to "fail"
	public XSSFSheet refreshStatus( XSSFSheet sheet) { 
		//Title Row i.e. tr
		Row tr = sheet.getRow(0);
		int status=getStatusColumn(tr);	
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			sheet.getRow(i).getCell(status).setCellValue("fail");
		}
		return sheet;
	}

	//it converts data row into key value pair concept where key is title row value and value is data row value
	//uncomment the below commented system.out.println(...)code to see working in console for below function
	public HashMap<String, String> getData(Row r, Row tr) {
		HashMap<String, String> data = new HashMap<String, String>();
		for (int j = 0; j < r.getLastCellNum(); j++) {
			Cell c = r.getCell(j);
			if (c.getCellType().toString().equals("STRING")) {
				data.put(tr.getCell(j).getStringCellValue(), c.getStringCellValue());
				//System.out.println(tr.getCell(j).getStringCellValue() + "      " + c.getStringCellValue());
			} else {
				data.put(tr.getCell(j).getStringCellValue(), Integer.toString((int) c.getNumericCellValue()));
				//System.out.println(tr.getCell(j).getStringCellValue() + "  "+ Integer.toString((int) c.getNumericCellValue()));
			}
		}
		return data;
	}
}
