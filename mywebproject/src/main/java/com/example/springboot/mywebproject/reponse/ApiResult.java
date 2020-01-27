package com.example.springboot.mywebproject.reponse;


public class ApiResult {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ApiResult() {
    }

    public ApiResult(boolean success,
                     String message,
                     Integer code) {
        this( success, message, code, null );
    }

    public ApiResult(boolean success,
                     String message,
                     Integer code,
                     Object data) {
        super();
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
