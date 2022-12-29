package com.sauravsharan;

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sauravsharan.interceptor.AuthenticationInterceptor
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


class OpenAiService(private val token: String, private val timeout: Int = 5) {

    private var baseUrl = "https://api.openai.com/v1/"
    private val client: OkHttpClient
    private val mapper = ObjectMapper()

    init {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE

        client = OkHttpClient.Builder()
            .addInterceptor(AuthenticationInterceptor(token))
            .connectionPool(ConnectionPool(5, 1, TimeUnit.SECONDS))
            .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
            .build()
    }

    fun baseUrl(url: String): OpenAiService {
        this.baseUrl = url;
        return this;
    }

    fun build(): OpenAiApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(OpenAiApi::class.java)
    }

}

