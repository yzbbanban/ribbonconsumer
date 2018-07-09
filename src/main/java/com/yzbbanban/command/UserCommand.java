package com.yzbbanban.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.yzbbanban.domain.User;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ban on 2018/7/7.
 */
public class UserCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private Long id;

    protected UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }


    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://UUABB-SERVICE/users/{1}", User.class, id);
    }
}
