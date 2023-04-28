package com.project.ad.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "adconf.mysql") //配置文件到java对象的转化
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinlogConfig {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String binlogName;
    private Long position;
}
