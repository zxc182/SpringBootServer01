package lianxi.demo02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Huanchongliu {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/resources/fos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("./src/resources/fos_copy2.txt");
		BufferedOutputStream bos  = new BufferedOutputStream(fos);
		
		int len = -1;
		while((len = bis.read()) != -1){
			bos.write(len);
		}
		System.out.println("复制完毕");
		bis.close();
		bos.close();
		
	}

}
