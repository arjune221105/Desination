package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcleFileUtility {
	/**
	 * This is method is used to the read the data from Excle File
	 * @param sheetname
	 * @param row
	 * @param col
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public String toReadDataFromExcleFile(String sheetname,int row,int col) throws EncryptedDocumentException, IOException {
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\Manual.xlsx");
		
		Workbook wb =WorkbookFactory.create(efis);
		
		String value = wb.getSheet(sheetname).getRow(row).getCell(col).toString();
		
		return value;
	}
	
	
	

		
		
		
		
		
		
		
	}


