package cn.brucemaa.springboot.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.repository
 * 基础Repository
 * @author Bruce Maa
 * @since 2019/12/5.15:20
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
}
