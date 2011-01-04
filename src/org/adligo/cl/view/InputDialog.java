package org.adligo.cl.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDialog {
	private String message;
	private String input;
	
	public InputDialog() {
		
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInput() {
		return input;
	}

	public void show() {
		System.out.println(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    try {
	         input = br.readLine();
	    } catch (IOException ioe) {
	        //do nothing
	    }
	}
}
