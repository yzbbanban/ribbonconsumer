package com.yzbbanban.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yzbbanban.service.ifac.IUuabbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ban on 2018/7/7.
 */
@Service
public class UuabbServiceImpl implements IUuabbService {


    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "uuabbFallback")
    @Override
    public String getService() {
        return restTemplate.getForEntity("http://UUABB-SERVICE/hello", String.class).getBody();
    }

    public String uuabbFallback() {
        return "error";
    }
}
