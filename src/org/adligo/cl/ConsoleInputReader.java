package org.adligo.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.adligo.i.adig.shared.BaseGInvoker;
import org.adligo.i.adig.shared.I_GInvoker;

/**
 * ignores input parameter
 * 
 * @author scott
 *
 */
public class ConsoleInputReader extends BaseGInvoker implements I_GInvoker<Object, String>{

	public ConsoleInputReader() {
		super(Object.class, String.class);
	}

	@Override
	public String invoke(Object valueObject) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    try {
	         return br.readLine();
	    } catch (IOException ioe) {
	        //do nothing
	    }
	    return "";
	}

}
