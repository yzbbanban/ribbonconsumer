package com.yzbbanban.service.ifac;

import com.yzbbanban.service.impl.UuabbServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ban on 2018/7/7.
 *
 * @author ban
 */
@FeignClient(value = "uuabb-service",fallback = UuabbServiceImpl.class)
public interface IUuabbService {
    @RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    String getService();
}
