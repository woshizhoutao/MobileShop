package com.example.mobileshop.http.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {
    private int status;
    private String msg;
    private T data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @NonNull
    @Override
    public String toString() {
        return "HttpResult{" +
                "data="+ data +
                ", status=" + status +
                ", msg=‘"+ msg + '\'' +
                '}';
    }
}

