package cn.brucemaa.springboot.template.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.entity
 * 数据假删除基类，提供假删除字段
 * @author Bruce Maa
 * @since 2019/12/4.11:51
 */
@MappedSuperclass
@Setter
@Getter
public abstract class AbstractFakeDeleteEntity extends BaseEntity {

    /**
     * 是否已删除：
     * 默认为false，未删除，数据库中存储未0；
     * true，已删除，数据库中存储未1
     */
    @JsonIgnore
    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean isDeleted = false;
}
