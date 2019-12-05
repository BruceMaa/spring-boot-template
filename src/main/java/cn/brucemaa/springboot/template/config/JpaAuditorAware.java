package cn.brucemaa.springboot.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

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
        // 获取当前登陆人
        return Optional.of(1L);
    }
}
