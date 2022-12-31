package com.nick.javatest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
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


    @Data
    @RequiredArgsConstructor
    static class Node{
        private final Integer id;
        private final String date;
        private final String zone;
    }
}
