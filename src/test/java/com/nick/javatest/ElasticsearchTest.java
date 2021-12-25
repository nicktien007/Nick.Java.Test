package com.nick.javatest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    private RestHighLevelClient client;


    @Test
    @SneakyThrows
    void testQueryIndex() {

        IndicesClient indices = client.indices();
        GetIndexResponse response = indices.get(new GetIndexRequest("person"), RequestOptions.DEFAULT);

        Map<String, MappingMetadata> mappings = response.getMappings();
        for (String k : mappings.keySet()) {
            log.info("key:{},value:{}", k, mappings.get(k).getSourceAsMap());
        }
    }
}