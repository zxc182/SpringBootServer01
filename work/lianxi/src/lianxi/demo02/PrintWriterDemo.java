package lianxi.demo02;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterDemo {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("./src/resources/fos.txt",true);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("---dfdfdfdfdffsd");
		System.out.println("写出完毕");
		pw.close();
		
	}

}
