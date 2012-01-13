package org.adligo.cl.args;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;

public class ArgParser {
	private static final Log log = LogFactory.getLog(ArgParser.class);
	
	/**
	 * this parses strings for command line input
	 * ie
	 * yourProgram.jar -help -threads='123' -mojo=0
	 * it returns empty strings for for items with out quotes
	 * so 
	 * -help would return ""
	 * -threads would return "123"
	 * and -mojo would return ""
	 * 
	 * @param valueObject
	 * @return
	 */
	public static Map<String,String> parse(String[] valueObject) {
		Map<String,String> toRet = new HashMap<String,String>();
		for (int i = 0; i < valueObject.length; i++) {
			String command = valueObject[i];
			if (log.isDebugEnabled()) {
				log.debug("parsing '" + command + "'");
			}
			char [] chars = command.toCharArray();
			StringBuilder keyBuilder = new StringBuilder();
			StringBuilder valueBuilder = new StringBuilder();
			
			boolean foundEquals = false;
			boolean foundFirstQuote = false;
			boolean foundLastQuote = false;
			
			for (int j = 0; j < chars.length; j++) {
				char c = chars[j];
				if (c == '=') {
					foundEquals = true;
				} else if (c == '\'') {
					if (!foundFirstQuote) {
						foundFirstQuote = true;
					} else {
						foundLastQuote = true;
					}
				} else {
					if (!foundEquals) {
						keyBuilder.append(c);
					} else {
						valueBuilder.append(c);
					}
				}
			}
			if (!foundLastQuote) {
				if (log.isDebugEnabled()) {
					log.debug("clearing value didn't find last quote");
				}
				valueBuilder = new StringBuilder();
			}
			if (log.isDebugEnabled()) {
				log.debug("adding command line " + 
						keyBuilder.toString() + "," +
						valueBuilder.toString());
			}
			toRet.put(keyBuilder.toString(), valueBuilder.toString());
		}
		return toRet;
	}
}
