package com.wukangjie.baselib.remote.gson;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.wukangjie.baselib.BuildConfig;
import com.wukangjie.baselib.remote.AppException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class BaseResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    private final Gson gson;

    /**
     * 登陆失效
     */
    private static final int LOG_OUT_TIME = -1001;

    BaseResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        try {
//            JSONObject result = new JSONObject(jsonString);
//
//
//            int code = result.getInt("code");
//            String errorMessage;
//            if (code != 0) {
//                //错误信息
//                if (code == LOG_OUT_TIME) {
//                    errorMessage = "登录失效，请重新登录";
//                } else {
//                    errorMessage = result.getString("msg");
//                }
//                //异常处理
//                throw new AppException(code, errorMessage, "");
//            }
            //正确返回整个json
            try {
                return adapter.fromJson(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            value.close();
        }
        return null;
    }

}