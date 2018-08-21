package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository  {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public Data find(DataRequest dataRes) {
		String query = "select * from recipe where recipeitem ="+dataRes.getRecipeid()+";";
		
		Data data = (Data)getJdbcTemplate().queryForObject(
				query, new CustomerRowMapper());
	    return data;
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbc;
	}

	public void saveData(IngredientReqDTO ing) {
		String sqlquery ="insert into recipe(ingredient1,ingredient2,ingredient3,ingredient4,recipeitem)values('"+
				ing.getIngredient1()+"','"+ing.getIngredient2()+"','"+ing.getIngredient3()+"','"+
				ing.getIngredient4()+"','"+ing.getRecipeName()+"');";
		getJdbcTemplate().execute(sqlquery);
	}

	public DataResponse findAll() {
		// TODO Auto-generated method stub
		String query = "select recipeitem from recipe";
		
		DataResponse data = (DataResponse)getJdbcTemplate().queryForObject(
				query, new CustomerRowMapper1());
	    return data;	}
}
