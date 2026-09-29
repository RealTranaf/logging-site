package com.vtc.logging.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogRequest {
    private String level;
    private String message;
    private String timestamp;
    private String url;
}
