package edu.computerpower.student.jsonserverdata;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import android.content.Context;


public class FileReadingUtility {
	
	public String readTextFile(Context c) {
		InputStream inputStream = c.getResources().openRawResource(R.raw.serverdatajson);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//byte[] b = null;
		int i;
		try {
			i = inputStream.read();
			while(i != -1) {
				outputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return outputStream.toString();
	}
	
//	public String readDataFromFile(String fileName) {
//		
//		File file = new File(fileName);
//		try {
//			Reader reader = new FileReader(file);
//			StringBuilder stringBuilder = new StringBuilder();
//			int i = 0;
//			while ((i = reader.read()) != -1) {
//				char c = (char)i;
//				stringBuilder.append(c);
//			}
//			reader.close();
//			return stringBuilder.toString();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
