package lianxi.demo02;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		//文件读取
		RandomAccessFile raf = new RandomAccessFile("./demo01.txt","rw");
		raf.writeBytes("fff");
		System.out.println(raf.read());
		String str  ="23232";
		byte[] data = str.getBytes("UTF-8");
		raf.write(data);
	}

}
