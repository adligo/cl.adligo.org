package org.adligo.cl.view.parsers;

import org.adligo.cl.view.I_InputParser;

public class IntegerInputParser implements I_InputParser {
	private int max_attempts = 10;
	private int nbr = 0;
	
	@Override
	public Object parse(String input) throws Exception {
		if (nbr >= max_attempts) {
			System.out.println("You have exceeded your " +
					"maximum number of attempts.");
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
