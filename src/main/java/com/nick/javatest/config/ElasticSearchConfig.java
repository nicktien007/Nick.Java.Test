package com.nick.javatest.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient client(){
        //local
//        return new RestHighLevelClient(RestClient.builder(
//                new HttpHost(
//                        "localhost",
//                        9200,
//                        "http"))
//        );

        //LAB
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost(
                        "140.120.182.90",
                        9160,
                        "http"))
        );
    }
}