package com.itinerary.guest.itinerary.model;

/**
 * The Class ResponseModel.
 */
public class ResponseModel {

/** The status code. */
private Integer statusCode;

/** The status msg. */
private String statusMsg;

/** The data. */
private Object data;

/**
* Gets the status code.
*
* @return the status code
*/
public final Integer getStatusCode() {
return statusCode;
}


/**
 * Sets the status code.
 *
 * @param statusCode1 the new status code
 */
public final void setStatusCode(final Integer statusCode1) {
this.statusCode = statusCode1;
}

/**
 * * Gets the status msg.
*
* @return the status msg
*/
public final String getStatusMsg() {
return statusMsg;
}


/**
 * Sets the status msg.
 *
 * @param statusMsg1 the new status msg
 */
public final void setStatusMsg(final String statusMsg1) {
this.statusMsg = statusMsg1;
}

/**
* Gets the data.
*
* @return the data
*/
public final Object getData() {
return data;
}

/**
 * Sets the data.
 *
 * @param data1 the new data
 */
public final void setData(final Object data1) {
this.data = data1;
}

/* (non-Javadoc)
* @see java.lang.Object#toString()
*/
@Override
public final String toString() {
return "ResponseStatus [statusCode="
+ statusCode + ", statusMsg=" + statusMsg + ", data=" + data + "]";
}

/**
* Gets the response status.
*
* @param statusCode the status code
* @param statusMsg the status msg
* @param data the data
* @return the response status
*/
public static ResponseModel getResponseStatus(
final Integer statusCode, final String statusMsg, final Object data) {

ResponseModel status = new ResponseModel();
status.setStatusCode(statusCode);
status.setStatusMsg(statusMsg);
if (data != null) {
status.setData(data);
}
return status;
}

}
