package net.cloudcentrik.dagenslunch.exception;

import java.util.Date;

public class DagenslunchErrorResponse {

    private DagenslunchErrorDetails error;

    public DagenslunchErrorResponse(Integer code, String message, String uri, Date time) {
        this.error=new DagenslunchErrorDetails(code,message,uri,time);
    }

    public DagenslunchErrorDetails getError() {
        return error;
    }

    public void setError(DagenslunchErrorDetails error) {
        this.error = error;
    }
}
