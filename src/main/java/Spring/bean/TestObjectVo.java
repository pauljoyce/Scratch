package Spring.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import Spring.config.YamlPropertyLoaderFactory;
import lombok.Data;

/**
 * @Author: mengchao
 * @Date: 2020/9/17 10:22
 */
@Data
@Component
@PropertySource(value = "classpath:test.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix ="testObject")
public class TestObjectVo {
    private int taskId;
    private String taskName;
}
