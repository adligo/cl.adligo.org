package org.adligo.cl;

import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GInvoker;

/**
 * accepts a integer for the System.exit call
 * 
 * @author scott
 *
 */
public class SystemExitor extends BaseGInvoker implements I_GInvoker<Integer, Object>{

	public SystemExitor() {
		super(Integer.class, Object.class);
	}

	@Override
	public Object invoke(Integer valueObject) {
		System.exit(valueObject);
		return null;
	}
	
}
