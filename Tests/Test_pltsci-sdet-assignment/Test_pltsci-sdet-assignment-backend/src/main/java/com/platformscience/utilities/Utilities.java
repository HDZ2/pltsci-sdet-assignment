package com.platformscience.utilities;

import com.platformscience.models.PltsciRequest;
import com.platformscience.models.PltsciResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
public PltsciResponse PostAsync(PltsciRequest pltsciRequest){
    String url = "http://localhost:8080/v1/cleaning-sessions";
//to do set this value in properties file
    String responseBody = new String();

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(pltsciRequest.toJson(), ContentType.APPLICATION_JSON));

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()))) {
                String line;
                StringBuilder responseBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }

                responseBody = responseBuilder.toString();
                return PltsciResponse.fromJson(responseBody);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return PltsciResponse.fromJson(responseBody);
}
}
