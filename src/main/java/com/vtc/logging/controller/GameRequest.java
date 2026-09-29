package com.vtc.logging.controller;

import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequest {
    public String name;
    public String description;
    public Platform platform;
    public PubStatus status;
}
