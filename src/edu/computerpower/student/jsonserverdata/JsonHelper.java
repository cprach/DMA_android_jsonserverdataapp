package edu.computerpower.student.jsonserverdata;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import android.app.Activity;
import com.google.gson.Gson;


public class JsonHelper {

	private String readDataFile(Activity activity) {
		InputStream inputStream = activity.getResources().openRawResource(R.raw.serverdatajson);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
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


	public ServerManager deserializeServerData(Activity activity) {
		Gson gson = new Gson();
		ServerManager serverManager = gson.fromJson(readDataFile(activity), ServerManager.class);
		return serverManager;
	}
	
	public String serializeServerData(ServerManager serverManager) {
		Gson gson = new Gson();
		String json = gson.toJson(serverManager);
		return json;
	}


}
