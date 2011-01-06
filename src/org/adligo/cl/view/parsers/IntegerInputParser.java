package org.adligo.cl.view.parsers;

import org.adligo.cl.CL_InvokerNames;
import org.adligo.cl.view.I_InputParser;
import org.adligo.i.adi.client.InvokerNames;
import org.adligo.i.adig.client.GRegistry;
import org.adligo.i.adig.client.I_GInvoker;

public class IntegerInputParser implements I_InputParser {
	private static I_GInvoker<String, Object> SYSTEM_OUT = GRegistry.getInvoker(
			InvokerNames.OUT, String.class, Object.class);
	private static I_GInvoker<Integer, Object> SYSTEM_EXITOR = GRegistry.getInvoker(
			CL_InvokerNames.SYSTEM_EXITOR, Integer.class, Object.class);
	
	private int max_attempts = 10;
	private int nbr = 0;
	
	@Override
	public Object parse(String input) throws Exception {
		if (nbr >= max_attempts) {
			SYSTEM_OUT.invoke("You have exceeded your " +
					"maximum number of attempts.");
			SYSTEM_EXITOR.invoke(0);
		}
		nbr++;
		StringBuilder sb = new StringBuilder();
		char [] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == ' ') {
				//skip
			} else if (c == '\t') {
				//skip
			} else if (c == ',') {
				//skip
			} else {
				sb.append(c);
			}
		}
		return Integer.parseInt(sb.toString());
	}

	public int getMax_attempts() {
		return max_attempts;
	}

	public void setMax_attempts(int max_attempts) {
		this.max_attempts = max_attempts;
	}

}
