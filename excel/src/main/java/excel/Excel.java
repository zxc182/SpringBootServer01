package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


/**
 * 导入excel
 * @author zxc
 *
 */
public class Excel {
	public static void main(String[] args) throws IOException {

		File file = new File("./src/main/resources/测试.xlsx");
		if(file.exists()) {
			System.out.println("文件存在");
		}
		Workbook workbook = null;
//		if (file.getPath().endsWith("xls")) {
//			System.out.println("这是2003版本");
//			workbook = new XSSFWorkbook(new FileInputStream(file));
//		} else if (file.getPath().endsWith("xlsx")){
//			workbook = new HSSFWorkbook(new FileInputStream(file));
//			System.out.println("这是2007版本");
//		}
//		workbook = new XSSFWorkbook(new FileInputStream(file));
//		// 获取第一个张表
//		Sheet sheet = workbook.getSheetAt(0);
//		// 获取每行中的字段
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//		  Row row = sheet.getRow(i);  // 获取行
//		  // 获取单元格中的值
//		  String studentNum = row.getCell(0).getStringCellValue();  
//		  String name = row.getCell(1).getStringCellValue();
//		  String phone = row.getCell(2).getStringCellValue();
//		  
//		  System.out.println("studentNum:"+studentNum);
//		  System.out.println("name:"+name);
//		  System.out.println("phone:"+phone);
//		}
		ReadExcel readExcel = new ReadExcel();

		FileInputStream input = new FileInputStream(file);

		MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
		@SuppressWarnings("unused")
		List<Map<String, Object>> userList = readExcel.getExcelInfo(multipartFile);  


	}

}
