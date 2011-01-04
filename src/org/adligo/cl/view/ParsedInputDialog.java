package org.adligo.cl.view;

public class ParsedInputDialog {
	private InputDialog originalDialog = new InputDialog();
	private InputDialog errorParsingDialog = new InputDialog();
	private I_InputParser parser;
	private Object parsed;
	
	public I_InputParser getParser() {
		return parser;
	}
	public void setParser(I_InputParser parser) {
		this.parser = parser;
	}
	public void setMessage(String message) {
		originalDialog.setMessage(message);
	}
	public void setErrorMessage(String message) {
		errorParsingDialog.setMessage(message);
	}
	public void show() {
		originalDialog.show();
		try {
			parsed = parser.parse(originalDialog.getInput());
		} catch (Exception x) {
			//do nothing but loop
		}
		while (parsed == null) {
			errorParsingDialog.show();
			try {
				parsed = parser.parse(errorParsingDialog.getInput());
			} catch (Exception x) {
				//do nothing but loop
			}
		}
	}
	public Object getParsed() {
		return parsed;
	}
	
}
