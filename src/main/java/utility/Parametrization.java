package utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Parametrization {
	
	public String getData(int row,int colunm,String sheet) throws EncryptedDocumentException, IOException
	{
		File file=new File("D:\\GitHubPractice\\Naaptol\\resource\\DataSheet.xlsx");
		return WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(colunm).getStringCellValue();
	}
	

}
