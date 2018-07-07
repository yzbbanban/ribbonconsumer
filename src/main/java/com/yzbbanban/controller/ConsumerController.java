package com.yzbbanban.controller;

import com.yzbbanban.service.ifac.IUuabbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ban on 2018/7/2.
 *
 * @author ban
 */
@RestController
public class ConsumerController {
    @Autowired
    IUuabbService iUuabbService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {

        return iUuabbService.getService();
    }

}
