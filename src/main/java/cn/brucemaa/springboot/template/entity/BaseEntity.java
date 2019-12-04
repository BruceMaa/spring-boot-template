package cn.brucemaa.springboot.template.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.entity
 * 基础父类，提供数据审计字段
 * @author Bruce Maa
 * @since 2019/12/4.11:41
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    /**
     * 数据创建人
     */
    @JsonIgnore
    @CreatedBy
    private Long createdBy;

    /**
     * 数据创建时间
     */
    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime createdTime;

    /**
     * 数据最后更新人
     */
    @JsonIgnore
    @LastModifiedBy
    private Long lastModifiedBy;

    /**
     * 数据最后更新时间
     */
    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime lastModifiedTime;
}
