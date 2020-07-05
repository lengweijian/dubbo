package com.atlwj.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.atlwj.framework.Invocation;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation){

        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, hostname, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();
            var client = java.net.http.HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
