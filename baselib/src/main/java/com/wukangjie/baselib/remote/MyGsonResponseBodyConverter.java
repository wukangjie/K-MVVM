package com.wukangjie.baselib.remote;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.wukangjie.baselib.model.BaseResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        String response = value.string();
        try {

        BaseResponse<T> baseBean = gson.fromJson(response, BaseResponse.class);
            return baseBean.getData();
        } finally {
            value.close();
        }
    }
}
