package cn.heclam.service;

import cn.heclam.entity.Goods;
import cn.heclam.entity.PageBean;

import java.util.Map;

public interface GoodsService extends BaseService<Goods> {

    /**
     * 搜索 -- 从Solr索引库中
     *
     * @param searchMap
     * @return
     */
    Map<String, Object> search(Map searchMap);

    /**
     * 分页查询
     * @param goods 查询条件
     * @param pageCode 当前页
     * @param pageSize 每页的记录数
     * @return
     */
    PageBean findByPage(Goods goods, int pageCode, int pageSize);
}
