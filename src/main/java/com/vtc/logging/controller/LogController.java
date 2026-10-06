//package com.vtc.logging.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = {"http://localhost:3000","http://117.103.203.180:3000"})
//@RestController
//@RequestMapping("/logs")
//public class LogController {
//    private static final Logger frontendLogger = LoggerFactory.getLogger("frontendLogger");
//
//    @PostMapping
//    public void receiveLog(@RequestBody LogRequest log) {
//        switch (log.getLevel()) {
//            case "INFO":
//                frontendLogger.info("{} | {}", log.getUrl(), log.getMessage());
//                break;
//            case "WARN":
//                frontendLogger.warn("{} | {}", log.getUrl(), log.getMessage());
//                break;
//            case "ERROR":
//                frontendLogger.error("{} | {}", log.getUrl(), log.getMessage());
//                break;
//            default:
//                frontendLogger.debug("{} | {}", log.getUrl(), log.getMessage());
//        }
//    }
//}
