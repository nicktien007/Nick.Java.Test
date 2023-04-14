package com.nick.javatest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class ApplicationTests {

    @Test
    void test1() {
        //java 8 之後版本
        List<Node> list = new ArrayList<>();

        //344筆
        list.add(new Node(1, "date1", "zone1"));
        list.add(new Node(2, "date1", "zone2"));
        list.add(new Node(3, "date1", "zone1"));
        list.add(new Node(4, "date2", "zone1"));
        list.add(new Node(5, "date2", "zone2"));
        list.add(new Node(6, "date2", "zone1"));


        Map<String, List<Node>> groupByDates = list.stream().collect(Collectors.groupingBy(Node::getDate));
        //date -> List<Node>
        //3/1 -> .....
        //3/2 -> .....

        groupByDates.forEach((date, nodesByDate) -> {
            nodesByDate.stream().collect(Collectors.groupingBy(Node::getZone)).forEach((zone, nodes) -> {
                log.info(nodes.toString());
                //做你想做的事情
                //送進去包裝成的方法去處理…
            });
        });
    }

    @Test
    void test2() {

        //java 8 之前版本
        List<Node> list = new ArrayList<>();

        list.add(new Node(1, "date1", "zone1"));
        list.add(new Node(2, "date1", "zone2"));
        list.add(new Node(3, "date1", "zone1"));
        list.add(new Node(4, "date2", "zone1"));
        list.add(new Node(5, "date2", "zone2"));
        list.add(new Node(6, "date2", "zone1"));


        Map<String, List<Node>> groupByDates = new HashMap<>();

        //groupBy date
        for (Node node : list){
            String date = node.getDate();
            List<Node> nodes = groupByDates.get(date);

            //如果是第一個key
            if (nodes == null) {
                nodes = new ArrayList<>();
                groupByDates.put(date, nodes);
            }

            nodes.add(node);
        }


        Map<String, List<Node>> groupByZone = new HashMap<>();
        //走訪groupByDates, group by date + zone
        for (Map.Entry<String, List<Node>> entry : groupByDates.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            List<Node> nodesByDate = entry.getValue();
            String date = entry.getKey();

            for (Node node : nodesByDate){
                String zone = node.getZone();
                List<Node> nodes = groupByZone.get(date+zone);

                if (nodes == null) {
                    nodes = new ArrayList<>();
                    groupByZone.put(date+zone, nodes);
                }

                nodes.add(node);
            }
        }


        log.info(groupByZone.toString());
    }

    @Test
    @SneakyThrows
    void test3() {
        UrlInfo urlInfo = new UrlInfo();

        List<UrlInfo.DataInfo> dataInfo = new ArrayList<>();

        dataInfo.add(new UrlInfo.DataInfo("http://skbanknewdev.walkflow.com.tw/resource/0c621715-3349-4314-9b80-fdc781e58ea3.jpg"));
//        dataInfo.add(new UrlInfo.DataInfo("http://skbanknewdev.walkflow.com.tw/resource/2.jpg"));
//        dataInfo.add(new UrlInfo.DataInfo("http://skbanknewdev.walkflow.com.tw/resource/3.jpg"));

        urlInfo.setData(dataInfo);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(urlInfo);


        log.info(json);
    }


    @Test
    @SneakyThrows
    void test4() {
        UrlInfo urlInfo = new UrlInfo();

        List<String> urls = new ArrayList<>();

        urls.add("http://skbanknewdev.walkflow.com.tw/resource/0c621715-3349-4314-9b80-fdc781e58ea3.jpg");
//        dataInfo.add(new UrlInfo.DataInfo("http://skbanknewdev.walkflow.com.tw/resource/2.jpg"));
//        dataInfo.add(new UrlInfo.DataInfo("http://skbanknewdev.walkflow.com.tw/resource/3.jpg"));

        Object o = addPreloadPurge(urls);
        log.info(o.toString());
    }


    public static <T> Optional<T> Try(Supplier<T> func, Function<Exception, Optional<T>> errorCallback) {
        try {
            return Optional.ofNullable(func.get());
        } catch (Exception ex) {

            log.error("ex error = ", ex);

            if (errorCallback != null) {
                return errorCallback.apply(ex);
            }
            return Optional.empty();
        }
    }



    @SneakyThrows
    private int testaa(int a) {

//        return a;
//        throw new Exception("aa");
        throw new RuntimeException("aa");
    }

    public Object addPreloadPurge(List<String> urls) throws JsonProcessingException {

        MultiValueMap<String, String> reqBody = new LinkedMultiValueMap<>();
        reqBody.add("token", "058d959219ef9da10fd382a25b535d394196c08f");
        reqBody.add("serviceID", "1");
        reqBody.add("serviceName", "skbank");
        reqBody.add("action", "purge");
        reqBody.add("useDeviceType", "0");
        reqBody.add("url", convertUrlsToJson(urls));


        return (AddPreloadPurgeResp)executeRequest("https://api.cdn.hinet.net/cdnPortalAPI/addPreloadPurge", reqBody, AddPreloadPurgeResp.class);
    }
    private String convertUrlsToJson(List<String> urls) throws JsonProcessingException {
        UrlInfo urlInfo = new UrlInfo();
        List<UrlInfo.DataInfo> dataInfo = urls.stream().map(UrlInfo.DataInfo::new).collect(Collectors.toList());

        urlInfo.setData(dataInfo);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(urlInfo);
    }

    private Object executeRequest(String path, MultiValueMap<String, String> reqBody, Class<? extends AddPreloadPurgeResp> respType) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            RestTemplate restTemplate = new RestTemplate();

            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(reqBody, httpHeaders);

            RequestCallback requestCallback = restTemplate.httpEntityCallback(httpEntity, respType);
            CustomMessageExtractor customMessageExtractor = new CustomMessageExtractor(respType, restTemplate.getMessageConverters());
            return restTemplate.execute(path,
                    HttpMethod.POST,
                    requestCallback,
                    customMessageExtractor);

        } catch (Exception ex) {
            log.error("Invoke CDN API error = ", ex);
            throw ex;
        }
    }

    private static class CustomMessageExtractor extends HttpMessageConverterExtractor<AddPreloadPurgeResp> {
        CustomMessageExtractor(Class<? extends AddPreloadPurgeResp> responseType, List<HttpMessageConverter<?>> messageConverters) {
            super(responseType, messageConverters);
        }

        @Override
        protected MediaType getContentType(ClientHttpResponse response) {
            return MediaType.APPLICATION_JSON;
        }
    }

    @NoArgsConstructor
    @Data
    static class UrlInfo{

        private List<DataInfo> data = new ArrayList<>();

        @RequiredArgsConstructor
        @Data
        public static class DataInfo {
            private final String url;
        }
    }

    @Data
    @RequiredArgsConstructor
    static class Node{
        private final Integer id;
        private final String date;
        private final String zone;
    }
}
