package cn.brucemaa.springboot.template.service;

import cn.brucemaa.springboot.template.entity.Template;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.service
 *
 * @author Bruce Maa
 * @since 2019/12/5.15:18
 */
public interface TemplateService {

    /**
     * 更新数据
     * @param template 数据
     */
    void updateById(Template template);
}
