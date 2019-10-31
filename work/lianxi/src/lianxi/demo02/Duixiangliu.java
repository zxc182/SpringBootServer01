package lianxi.demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Duixiangliu {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("./src/resources/Huanchongliu.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		/*
		 * FileInputStream fis = new
		 * FileInputStream("./src/lianxi/demo02/Huanchongliu.java"); ObjectInputStream
		 * ois = new ObjectInputStream(fis);
		 * 
		 * int len = -1; byte[] data = new byte[1024*10]; while((len =
		 * ois.read(data))!=-1) { oos.write(data); } System.out.println("复制完毕");
		 * oos.close(); ois.close();
		 */
		
	}

}
