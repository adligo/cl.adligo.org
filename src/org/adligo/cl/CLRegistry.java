package org.adligo.cl;

import org.adligo.i.adig.client.GRegistry;

public class CLRegistry {

	public static void setup() {
		GRegistry.addInvoker(CL_InvokerNames.CONSOLE_INPUT_READER, new ConsoleInputReader());
		GRegistry.addInvoker(CL_InvokerNames.SYSTEM_EXITOR, new SystemExitor());	
	}
}
