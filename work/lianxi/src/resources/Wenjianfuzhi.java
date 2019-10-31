package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Wenjianfuzhi {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/resources/fos.txt");
		FileOutputStream fos = new FileOutputStream("./src/resources/fos_copy.txt");
		byte[] data = new byte[1024*10];
		int len = -1;
		while((len = fis.read(data)) != -1) {
			fos.write(data,0,len);
		}
		System.out.println("复制完毕");
		fis.close();
		fos.close();
	}

}
