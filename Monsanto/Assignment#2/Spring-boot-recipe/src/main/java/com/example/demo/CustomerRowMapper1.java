package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper1 implements RowMapper<DataResponse> {

	@Override
	public DataResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataResponse resp = new DataResponse();
		List<String> listRecipe = new ArrayList<>();
		while(rs.next()) {
			listRecipe.add(rs.getString("recipeitem"));
		}
		resp.setListofRecipe(listRecipe);
		 return resp;
	}

}
