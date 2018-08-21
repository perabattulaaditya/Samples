package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Data> {
	

	@Override
	public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
		Data data = new Data();
		data.setIngredient1(rs.getString("ingredient1"));
		data.setIngredient2(rs.getString("ingredient2"));
		data.setIngredient3(rs.getString("ingredient3"));
		data.setIngredient4(rs.getString("ingredient4"));
		return data;
	}
}
