package com.qitong.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference //远程引用指定的服务，他会按照全类名进行匹配，看谁给注册中心注册了这个全类名
            TicketService ticketService;

    public void bugTicket() {
        String res = ticketService.getTicket();
        System.out.println("我从服务段拿到了===>" + res);
    }
}
