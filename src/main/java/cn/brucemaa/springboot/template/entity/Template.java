package cn.brucemaa.springboot.template.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.entity
 *
 * @author Bruce Maa
 * @since 2019/12/5.13:19
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = " is_deleted = 0 ")
@Data
@EqualsAndHashCode(callSuper = true)
public class Template extends AbstractFakeDeleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;

    private String str;

    private Integer integer;

    private LocalDate localDate;

    private LocalTime localTime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime localDateTime;
}
