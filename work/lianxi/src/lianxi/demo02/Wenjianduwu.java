package lianxi.demo02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Wenjianduwu {

	public static void main(String[] args) throws IOException {
		//先创建一个文件
		FileOutputStream fos = new FileOutputStream("./src/resources/fos.txt");
		String s = "dkfdfldlfdfereffffffffffffffffffffffffffffdffffff";
		//指定编码
		byte[] da = s.getBytes("utf-8");
		fos.write(da);
		//读取文件
		FileInputStream fis = new FileInputStream("./src/resources/fos.txt");
		//每次读取10个字节
		byte[] data = new byte[100];
		int len = fis.read(data);
		String str = new String(data,0,len, "utf-8");
		System.out.println(str);
		fis.close();
	}

}
