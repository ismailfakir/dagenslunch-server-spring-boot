package net.cloudcentrik.dagenslunch.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DagenslunchErrorDetails {
    private Integer code;
    private String message;
    private String requestUri;
    private String timeStamp;

    public DagenslunchErrorDetails(Integer code, String message, String requestUri, Date timeStamp) {
        this.code = code;
        this.message = message;
        this.requestUri = requestUri.replace("uri=","");

        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        this.timeStamp = time_formatter.format(timeStamp);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


}