package com.nick.javatest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.javatest.config.CafeInfo;
import com.nick.javatest.entity.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    private RestHighLevelClient client;

    private ObjectMapper objectMapper = new ObjectMapper();

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

    @Test
    @SneakyThrows
    void testAddDocByMap() {

        Map map = new HashMap();
        map.put("name", "nick4");
        map.put("age", 38);
        map.put("address", "nick4 address");

        IndexRequest req = new IndexRequest("person").id(UUID.randomUUID().toString()).source(map);

        IndexResponse resp = client.index(req, RequestOptions.DEFAULT);

        log.info(resp.getId());

    }

    @Test
    @SneakyThrows
    void testAddDocByEntity() {

        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("nick5");
        person.setAddress("nick5 address");
        person.setAge(38);


        IndexRequest req = new IndexRequest("person")
                .id(person.getId())
                .source(objectMapper.writeValueAsString(person), XContentType.JSON);

        IndexResponse resp = client.index(req, RequestOptions.DEFAULT);

        log.info(resp.getId());
    }

    @Test
    @SneakyThrows
    void testGetDocById() {

        GetResponse resp = client.get(new GetRequest("person", "1"), RequestOptions.DEFAULT);

        log.info(resp.getSourceAsString());
    }

    @Test
    @SneakyThrows
    void testUpdateDoc() {

        GetResponse resp = client.get(new GetRequest("person", "d318e410-5b6d-46d5-936a-c2b6f9e930b6"), RequestOptions.DEFAULT);

        Person person = objectMapper.readValue(resp.getSourceAsString(), Person.class);
        person.setAddress("我超愛信用卡和提款卡");

        IndexRequest req = new IndexRequest("person")
                .id(person.getId())
                .source(objectMapper.writeValueAsString(person), XContentType.JSON);

        IndexResponse indexResponse = client.index(req, RequestOptions.DEFAULT);

        log.info(indexResponse.getId());
    }

    @Test
    @SneakyThrows
    void testDeleteDocById() {

        DeleteResponse resp = client.delete(new DeleteRequest("person", "e7-x8H0BEkR3D5eS_RSi"), RequestOptions.DEFAULT);

        log.info(resp.getId());
    }

    @Test
    @SneakyThrows
    void testGetCafeInfoByFile() {

        List<CafeInfo> cafeInfos = objectMapper.readValue(Paths.get("src/test/cafe/taichung.json").toFile(), new TypeReference<List<CafeInfo>>() {});

        log.info(cafeInfos.size() + "");
    }

    @Test
    @SneakyThrows
    void testAddCafeInfoToElastic() {

        List<CafeInfo> cafeInfos = objectMapper.readValue(Paths.get("src/test/cafe/cafes.json").toFile(), new TypeReference<List<CafeInfo>>() {});

        BulkRequest req = new BulkRequest();

        for (CafeInfo x : cafeInfos) {
            req.add(
                    new IndexRequest("cafe")
                            .id(x.getId())
                            .source(objectMapper.writeValueAsString(x), XContentType.JSON)
            );
        }

        client.bulk(req, RequestOptions.DEFAULT);
    }
}