package com.itinerary.dining.model;

/**
 * ResposeStatus.
 * final class
 * @author akuma408 ResposeStatus
 */
public final class ResposeStatus {
	/**
	 * constructor.
	 */
	private ResposeStatus() {
	}

	/**
	 * statusCode.
	 */
	private Integer statusCode;
	/**
	 * statusMsg.
	 */
	private String statusMsg;
	/**
	 * data.
	 */
	private Object data;

	/**
	 * getData.
	 * return object
	 * @return Object Object
	 */
	public Object getData() {
		return data;
	}

	/**
	 * setData.
	 * setdata
	 * @param data1
	 *            data1
	 */
	public void setData(final Object data1) {
		this.data = data1;
	}

	/**
	 * getStatusCode.
	 * return integer code
	 * @return Integer statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * setStatusCode.
	 * return string msg
	 * @param statusCode1
	 *            statusCode1
	 */
	public void setStatusCode(final Integer statusCode1) {
		this.statusCode = statusCode1;
	}

	/**
	 * getStatusMsg.
	 * getstatus
	 * @return String statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * setStatusMsg.
	 * setstatus
	 * @param statusMsg1
	 *            statusMsg1
	 */
	public void setStatusMsg(final String statusMsg1) {
		this.statusMsg = statusMsg1;
	}

	/**
	 * toString.
	 */
	@Override
	public String toString() {
		return "ResponseStatus [statusCode=" + statusCode + ","
				+ " statusMsg="
	+ statusMsg + ", data=" + data + "]";
	}

	/**
	 * getResponseStatus.
	 * return msg.
	 * @param statusCode
	 *            statusCode
	 * @param statusMsg
	 *            statusMsg
	 * @param data
	 *            data
	 * @return ResposeStatus ResposeStatus
	 */
	public static ResposeStatus getResponseStatus(final Integer
			statusCode, final String statusMsg, final Object data) {

		ResposeStatus status = new ResposeStatus();
		status.setStatusCode(statusCode);
		status.setStatusMsg(statusMsg);
		if (data != null) {
			status.setData(data);
		}
		return status;
	}
}
