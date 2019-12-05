package cn.brucemaa.springboot.template.controller;

import cn.brucemaa.springboot.template.entity.Template;
import cn.brucemaa.springboot.template.repository.TemplateRepository;
import cn.brucemaa.springboot.template.service.TemplateService;
import cn.brucemaa.springboot.template.vo.GlobalResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.controller
 *
 * @author Bruce Maa
 * @since 2019/12/5.15:19
 */
@RequiredArgsConstructor(onConstructor = @__({@Autowired}), access = AccessLevel.PUBLIC)
@RestController
@RequestMapping(value = "/templates")
public class TemplateController extends BaseController {

    private final TemplateService templateService;
    private final TemplateRepository templateRespository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public GlobalResponse save(@RequestBody Template template) {
        return GlobalResponse.ok(templateRespository.save(template));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GlobalResponse page(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "100") Integer size) {
        return GlobalResponse.ok(templateRespository.findAll(PageRequest.of(page - 1, size)));
    }

    @GetMapping(value = "/{templateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GlobalResponse findById(@PathVariable Long templateId) {
        return GlobalResponse.ok(templateRespository.findById(templateId));
    }

    @PutMapping(value = "/{templateId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GlobalResponse updateById(@PathVariable Long templateId,
                                     @RequestBody Template template) {
        template.setTemplateId(templateId);
        templateService.updateById(template);
        return GlobalResponse.ok();
    }

    @DeleteMapping(value = "/{templateId}")
    public GlobalResponse deleteById(@PathVariable Long templateId) {
        templateRespository.deleteById(templateId);
        return GlobalResponse.ok();
    }
}
