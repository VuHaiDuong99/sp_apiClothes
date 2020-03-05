package com.sapo.apiclothes.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product_DetailMapper implements RowMapper<Product_ProductDetail> {
    @Override
    public Product_ProductDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product_ProductDetail pro = new Product_ProductDetail();
        pro.setId(rs.getInt("product_id"));
        pro.setName_product(rs.getString("p.name"));
        pro.setName_color(rs.getString("c.name"));
        pro.setName_size(rs.getString("s.name"));
        pro.setAmout(rs.getInt("amount"));
        return pro;
    }
}
