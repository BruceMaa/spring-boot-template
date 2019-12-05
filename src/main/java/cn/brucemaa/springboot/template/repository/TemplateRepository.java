package cn.brucemaa.springboot.template.repository;

import cn.brucemaa.springboot.template.entity.Template;
import org.springframework.stereotype.Repository;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.repository
 *
 * @author Bruce Maa
 * @since 2019/12/5.13:21
 */
@Repository
public interface TemplateRepository extends FakeDeleteRepository<Template, Long> {
}
