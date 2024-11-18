package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppListener {

    @Value("${test.aa}")
    private List<String> aa;

    @EventListener(ApplicationReadyEvent.class)
    public void startup() {
        log.info(aa.toString());
    }
}
