package cn.brucemaa.springboot.template.repository;

import cn.brucemaa.springboot.template.entity.AbstractFakeDeleteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
     * 先根据主键查出数据，再修改字段值
     * @param id 数据主键
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    default void deleteById(ID id) {
        Optional<T> optional = findById(id);
        if (optional.isPresent()) {
            T t = optional.get();
            t.setIsDeleted(true);
        }
    };

}
