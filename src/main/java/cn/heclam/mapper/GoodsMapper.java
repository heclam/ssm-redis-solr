package cn.heclam.mapper;

import cn.heclam.entity.Goods;
import com.github.pagehelper.Page;

import java.util.List;

public interface GoodsMapper {

    List<Goods> findAll();

    Page<Goods> findByPage(Goods goods);

    List<Goods> findById(Long id);

    void create(Goods goods);

    void update(Goods goods);

    void delete(Long id);

    /**
     * 获取通过自增组件最新插入的id值
     *
     * @return
     */
    Long maxId();
}
