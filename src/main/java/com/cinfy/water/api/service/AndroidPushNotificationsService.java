package com.cinfy.water.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AndroidPushNotificationsService {

	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	private static final String FIREBASE_SERVER_KEY = "AAAAoxOShnw:APA91bEVfnXpFbHKa3IZU9OMF6z5i0i_OBc5Rvu_-w5u48xD6t2KLsnNmGMqkquOT9TWXZH0mW_jNgtmnnHgY1t3vBO3-7E2960TQ9UA-NcO3f8ncQ3BS2UDqkNBGaIaE8DLlbyXYegm";

	public static String sendPushNotification(String title,List<String> putIds2, String message, String message1)
			throws IOException {

		String result = "";
		URL url = new URL(FIREBASE_API_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + FIREBASE_SERVER_KEY);
		conn.setRequestProperty("Content-Type", "application/json");

		//JSONObject json = new JSONObject();
		JSONObject objData = new JSONObject();
		
		String concate_message=message+"\n"+message1;

		try {
//			for (int i = 0; i < putIds2.size(); i++) {
//				// regId.put(putIds2.get(i));
//				json.put("to", putIds2.get(i));
//			}
			// json.put("to", deviceToken);

//			JSONObject data = new JSONObject();
//			data.put("Key-1", Message);
//			data.put("Key-2", Message1);
//			json.put("data", data);
//			JSONObject info = new JSONObject();
//			info.put("title", "EZBitex Exchange"); // Notification title
//			info.put("body", "EZBitex Exchange"); // Notification
//			info.put("message", "hello user"); // body
//			json.put("notification", info);

			JSONArray regId = null;
			//JSONObject objData = null;
			JSONObject data = null;
			JSONObject notif = null;

			regId = new JSONArray();
			for (int i = 0; i < putIds2.size(); i++) {
				regId.put(putIds2.get(i));
			}
			data = new JSONObject();
			data.put("message", concate_message);
			notif = new JSONObject();
			notif.put("title", title);
			notif.put("text", concate_message);
			notif.put("click_action", "OPEN_ACTIVITY_1");

			//objData = new JSONObject();
			objData.put("registration_ids", regId);
			objData.put("data", data);
			objData.put("notification", notif);
			System.out.println("!_@rj@_group_PASS:>" + objData.toString());
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		try {
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(objData.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			result = "succcess";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		System.out.println("GCM Notification is sent successfully");

		return result;

	}
	
	public static String sendOneByOnePushNotification(String title,String deviceToken, String message, String message1)
			throws IOException {

		String result = "";
		String concate_message= message+"\n"+message1;
		
		System.out.println("concate_message+_+_"+concate_message);
		URL url = new URL(FIREBASE_API_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + FIREBASE_SERVER_KEY);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		//JSONObject objData = new JSONObject();

		try {

			json.put("to", deviceToken);

			JSONObject data = new JSONObject();
			data.put("message", concate_message);
			//data.put("Key-2", message1);
		
		
			
			JSONObject info = new JSONObject();
			info.put("title", title); // Notification title
			//info.put("body", message1); // Notification
			info.put("text", concate_message);
			//info.put("message", "hello user"); // body
			//info.put("click_action", "OPEN_ACTIVITY_1");
			
			json.put("data", data);
			json.put("notification", info);
			json.put("click_action", "OPEN_ACTIVITY_1");
		

//			JSONArray regId = null;
//			//JSONObject objData = null;
//			JSONObject data = null;
//			JSONObject notif = null;
//
//			regId = new JSONArray();
//			for (int i = 0; i < putIds2.size(); i++) {
//				regId.put(putIds2.get(i));
//			}
//			data = new JSONObject();
//			data.put("message", message);
//			notif = new JSONObject();
//			notif.put("title", "PTM Message");
//			notif.put("text", message1);
//			notif.put("click_action", "OPEN_ACTIVITY_1");

			//objData = new JSONObject();
//			json.put("registration_ids", regId);
//			json.put("data", data);
//			json.put("notification", notif);
			System.out.println("!_@rj@_group_PASS:>" + json.toString());
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		try {
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			result = "succcess";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		System.out.println("GCM Notification is sent successfully");

		return result;

	}
}