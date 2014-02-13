package org.adligo.cl.view;

import org.adligo.cl.CL_InvokerNames;
import org.adligo.i.adi.shared.InvokerNames;
import org.adligo.i.adig.shared.GRegistry;
import org.adligo.i.adig.shared.I_GInvoker;

public class InputDialog {
	private static I_GInvoker<String, Object> SYSTEM_OUT = GRegistry.getInvoker(
			InvokerNames.OUT, String.class, Object.class);
	private static I_GInvoker<Object, String> CONSOLE_INPUT_READER = GRegistry.getInvoker(
			CL_InvokerNames.CONSOLE_INPUT_READER, Object.class, String.class);
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
		SYSTEM_OUT.invoke(message);
		input = CONSOLE_INPUT_READER.invoke(null);
	}
}
