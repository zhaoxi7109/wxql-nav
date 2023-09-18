package com.zhaoxi.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后台启动类
 *
 * @author zhaoxi
 */
@SpringBootApplication(scanBasePackages = "com.zhaoxi")
@MapperScan("com.zhaoxi.**.mapper")
public class WXQLNavAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WXQLNavAdminApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  万相千络导航启动成功   ლ(´ڡ`ლ)ﾞ ");
    }

}
