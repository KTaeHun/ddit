package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long startTime = System.currentTimeMillis();
		
		int data = 0;

		try {
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}

		} catch (IOException ex) {
			ex.printStackTrace();

		} finally {
			try {
				fis.close();
				fos.close();
				bis.close();
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("걸린시간 : " 
				+ (endTime - startTime));
	}
}