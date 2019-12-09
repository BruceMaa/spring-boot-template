package cn.brucemaa.springboot.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.Random;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.config
 * 自动添加审计字段数据
 * @author Bruce Maa
 * @since 2019/12/5.15:14
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        // TODO 获取当前登陆人，目前是随机数，应用时根据自己需要修改
        return Optional.of((long) (new Random().nextDouble() * 9) + 1);
    }
}
