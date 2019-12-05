package cn.brucemaa.springboot.template.repository;

import cn.brucemaa.springboot.template.entity.AbstractFakeDeleteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.repository
 * 数据假删除Repository
 * @author Bruce Maa
 * @since 2019/12/5.13:22
 */
@NoRepositoryBean
public interface FakeDeleteRepository<T extends AbstractFakeDeleteEntity, ID> extends BaseRepository<T, ID> {

    /**
     * 数据假删除
     * TODO 主键不能写死
     * @param id 数据主键
     */
    @Override
    @Modifying
    @Query("update #{#entityName} e set e.isDeleted = true where e.templateId = :id")
    void deleteById(ID id);

}
