package org.adligo.cl.view;

public interface I_InputParser {
	/**
	 * parse your input into a Integer, Long, File (path) exc
	 * also can do System.exit for number of failures
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public Object parse(String input) throws Exception;
}
