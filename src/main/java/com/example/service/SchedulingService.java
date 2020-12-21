package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    //需要配置一个表达式：用来表示什么时候执行
    //cron表达式
    //依次表示 秒 分 时 日 月 星期几(0和7表示周日)
    //"0 * * * * 0-7" 这个表达式表示 每个月的周一到周期的0秒，也就是任意时间的0秒
    @Scheduled(cron = "0 59 19 * * ?")//表示任意时间的19时58分0秒
    private void hello(){
        System.out.println("定时任务执行了");
    }
}
