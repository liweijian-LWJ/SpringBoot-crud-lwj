package com.lwj.crud.util;

public class ResponseDto {
    private String code;
    private Object data;
    private String message;

    public String getCode() {
        return code == null ? "" : code.trim();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto [code=" + code + ", data=" + data + ", message=" + message + "]";
    }

    public ResponseDto(String code, Object data, String message) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResponseDto() {
        super();
    }
}
