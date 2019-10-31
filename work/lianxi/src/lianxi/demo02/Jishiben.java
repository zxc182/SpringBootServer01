package lianxi.demo02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Jishiben {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件名：");
		String fileName = sc.nextLine();
		RandomAccessFile raf = new RandomAccessFile("./src/resources/"+fileName+".txt","rw");
		System.out.println("请开始输入内容：");
		while(true) {
			String line = sc.nextLine();
			if("exit".equals(line)) {
				break;
			}
			byte[] data = line.getBytes("utf-8");
			raf.write(data);
		}
		System.out.println("再见！");
		raf.close();
	}

}
