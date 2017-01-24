package com.itinerary.resort.model;

/***
 * ResponseStatus.
 * class
 * @author akuma408
 *
 */
public class ResponseStatus {
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
     * @return Integer
     */
    public final Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode1
     *            statusCode1
     */
    public final void setStatusCode(final Integer statusCode1) {
        this.statusCode = statusCode1;
    }

    /**
     * @return statusMsg
     */
    public final String getStatusMsg() {
        return statusMsg;
    }

    /**
     * @param statusMsg1
     *            statusMsg1
     */
    public final void setStatusMsg(final String statusMsg1) {
        this.statusMsg = statusMsg1;
    }

    /**
     * @return data
     */
    public final Object getData() {
        return data;
    }

    /**
     * @param data1
     *            data
     */
    public final void setData(final Object data1) {
        this.data = data1;
    }

    /**
     * changing to tostring.
     */
    @Override
    public final String toString() {
        return "ResponseStatus [statusCode=" + statusCode + ","
                + " statusMsg=" + statusMsg + ", data=" + data + "]";
    }

    /**
     * getResponseStatus.
     * method
     * @param statusCode
     *            statusCode
     * @param statusMsg
     *            statusMsg
     * @param data
     *            data
     * @return ResponseStatus
     */
    public static final ResponseStatus getResponseStatus(final Integer
            statusCode, final String statusMsg, final Object data) {

        ResponseStatus status = new ResponseStatus();
        status.setStatusCode(statusCode);
        status.setStatusMsg(statusMsg);
        if (data != null) {
            status.setData(data);
        }
        return status;
    }

}
