package com.yq;

import com.yq.util.HttpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 晴 on 2017/6/4.
 */
@SpringBootApplication
public class Start implements ApplicationListener<ApplicationReadyEvent> {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "66842");
        try {
            String result = HttpUtils.get("http://music.163.com/song", map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
