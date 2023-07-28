package Models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class User {

	protected int user_id;
	private String username;
	protected String password;
	
	protected String URL = "http://localhost:3000/";

	/*
	 * Constructors
	 */

	public User(int user_id, String username, String password) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username) {
		this.username = username;
	}

	public String all_users() {		
		String all_users = null;
		
		String URL = this.URL + "user/";
		
		try {
			URL url = new URL(URL);
			System.out.println(url);
			HttpURLConnection conection = (HttpURLConnection) url.openConnection();

			conection.setRequestMethod("GET");
			conection.setRequestProperty("Accept", "application/json");

			if (conection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conection.getResponseCode());
			}

			InputStreamReader in = new InputStreamReader(conection.getInputStream());
			BufferedReader br = new BufferedReader(in);
			
			String output;
			
			while ((output = br.readLine()) != null) {
				all_users = output;
			}

			conection.disconnect();
		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}

		return all_users;
		
	}

	public int login() {

		String URL = this.URL + "user/login";
		
		// TODO: /user/login POST

		return 0;
	}

	public static void create_user() {
		// TODO: /user/ POST
	}

}
