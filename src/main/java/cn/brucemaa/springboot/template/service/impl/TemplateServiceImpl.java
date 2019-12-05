package cn.brucemaa.springboot.template.service.impl;

import cn.brucemaa.springboot.template.entity.Template;
import cn.brucemaa.springboot.template.repository.TemplateRepository;
import cn.brucemaa.springboot.template.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.service.impl
 *
 * @author Bruce Maa
 * @since 2019/12/5.15:18
 */
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(@NotNull Template template) {
        Optional<Template> templateOptional = templateRepository.findById(template.getTemplateId());
        if (templateOptional.isPresent()) {
            Template template1 = templateOptional.get();
            template1.setInteger(template.getInteger());
            template1.setStr(template.getStr());
            template1.setLocalDateTime(template.getLocalDateTime());
        }
    }
}
