package com.prathamesh.model;

public class ErrorData {

	private String message;
	private String datetime;
	private String module;
	public ErrorData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorData(String message, String datetime, String module) {
		super();
		this.message = message;
		this.datetime = datetime;
		this.module = module;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "ErrorData [message=" + message + ", datetime=" + datetime + ", module=" + module + "]";
	}
	
}
