package com.sapo.apiclothes.dao;

import com.sapo.apiclothes.entity.Product_DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDetail {
    @Autowired

    JdbcTemplate jdbcTemplate;
    public List getProductDetailById(int id){
        String sql ="select p.product_id, p.name , c.name, s.name , pd.amount from color c , products p ,size s , product_detail pd " +
                "where c.color_id = pd.id_color and p.product_id = pd.product_id  and s.size_id = pd.id_size and p.product_id ="+id;
        return jdbcTemplate.query(sql,new Product_DetailMapper());
    }
}
