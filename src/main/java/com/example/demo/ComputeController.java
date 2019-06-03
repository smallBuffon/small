package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @Auther: 20170308
 * @Date: 2019/6/3 10:30
 * @Description:
 */
@RestController
public class ComputeController {

    private final Logger logger=Logger.getLogger(getClass().getName());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a,@RequestParam Integer b){
        ServiceInstance serviceInstance=client.getLocalServiceInstance();
        Integer r=a+b;
        logger.info("/add,host:"+serviceInstance.getHost()+",serverid:"+serviceInstance.getServiceId()+",result="+r);
        return r;
    }

}
