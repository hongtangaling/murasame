package com.murasame_ai.murasame_singapi.util;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import org.springframework.stereotype.Component;
import retrofit2.http.GET;

@Component
@RetrofitClient(baseUrl = "http://localhost:23456/voice/vits?text=你好,こんにちは&id=0")   //请求格式
public interface RetrofitUtil {
//    @GET("test/getList")
//    List<TestEntity> getList(@Query("pageNum") Integer pageNum, @Query("pageSize") Integer pageSize);
//调取百度翻译的接口

}
