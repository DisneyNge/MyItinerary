package com.itinerary.guest.profile.model;

/**
 * @author nadubey ResponseStatus.
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
     * @return data.
     */
    public final Object getData() {
        return data;
    }

    /**
     * @param data1
     *            **this is data1 of guest**
     */
    public final void setData(final Object data1) {
        data = data1;
    }

    /**
     * @return statusCode.
     */
    public final Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode1
     *            **this is statusCode1 of guest**
     */
    public final void setStatusCode(final Integer statusCode1) {
        statusCode = statusCode1;
    }

    /**
     * @return statusMsg.
     */
    public final String getStatusMsg() {
        return statusMsg;
    }

    /**
     * @param statusMsg1
     *            **this is statusMsg1 of guest**
     */
    public final void setStatusMsg(final String statusMsg1) {
        statusMsg = statusMsg1;
    }

    /**
     * @return String
     */
    @Override
    public final String toString() {
        return "ResponseStatus [statusCode=" + statusCode + "," + " statusMsg="
                + statusMsg + ", data=" + data + "]";
    }

    /**
     * @param statusCode
     *            **this is statusCode of guest**
     * @param statusMsg
     *            **this is statusMsg of guest**
     * @param data
     *            **this is data of guest**
     * @return status
     */
    public static ResponseStatus getResponseStatus(final Integer statusCode,
            final String statusMsg, final Object data) {

        ResponseStatus status = new ResponseStatus();
        status.setStatusCode(statusCode);
        status.setStatusMsg(statusMsg);
        if (data != null) {
            status.setData(data);
        }
        return status;
    }
}
