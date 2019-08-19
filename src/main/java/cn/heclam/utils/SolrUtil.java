package cn.heclam.utils;

import cn.heclam.entity.Goods;
import cn.heclam.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实现将数据库中的数据批量导入到Solr索引库中
 *这是第一种方法将先查询数据库里面所有的good数据，然后调用SolrTemplate.saveBeans(goods),保存到索引库里面
 * 第二种方法：
 * 到new_core/conf/db-data-config.xml配置一下数据库的信息，即可将solr绑定数据库里面的数据
 * 重要的是一定要记得到new_core/conf/managed-schema中配置域
 */
@Component
public class SolrUtil {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    /**
     * 实现将数据库中的数据批量导入到Solr索引库中
     */
    public void importGoodsData() {

        List<Goods> list = goodsMapper.findAll();
        System.out.println("====商品列表====");
        for (Goods goods : list) {
            System.out.println(goods.getTitle());
        }

        solrTemplate.saveBeans(list);
        solrTemplate.commit(); //提交
        System.out.println("====结束====");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring*.xml");
        SolrUtil solrUtil = (SolrUtil) context.getBean("solrUtil");
        solrUtil.importGoodsData();
    }
}
