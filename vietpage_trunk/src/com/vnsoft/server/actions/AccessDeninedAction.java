package com.vnsoft.server.actions;


public class AccessDeninedAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4232915369665525018L;
	private String content;

	@Override
	public String execute() {
		return SUCCESS;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
