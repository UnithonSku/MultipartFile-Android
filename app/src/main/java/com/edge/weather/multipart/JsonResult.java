package com.edge.weather.multipart;

/**
 * Created by cs618 on 2017-07-14.
 */

public class JsonResult<DataType> {
    private String result;
    private String message;
    private DataType data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
