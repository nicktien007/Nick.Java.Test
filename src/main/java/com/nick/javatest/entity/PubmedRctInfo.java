package com.nick.javatest.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PubmedRctInfo {
    private final String articleId;
    private final String sentence;
    private final PubmedType type;
}