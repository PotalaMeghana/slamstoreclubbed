package eStoreProduct.DAO.customer;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.customer.input.Category;
import eStoreProduct.model.customer.input.CategoryRowMapper;

@Component
public class categoryDAOImp1 implements CategoryDAO1{
	
	JdbcTemplate jdbcTemplate;
	private String SQL_INSERT_CATEGORY = "insert into slam_productCAtegories(prct_id,prct_title,prct_desc) values(?,?,?)";
	private String SQL_GET_TOP_CATGID = "select prct_id from slam_productCAtegories order by prct_id desc limit 1";
	private String SQL_GET_CATEGORIES="SELECT prct_title FROM slam_productCategories";

	@Autowired
	public categoryDAOImp1(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//add new category method to database
	@Override
	public boolean addNewCategory(Category catg) {
		int c_id = jdbcTemplate.queryForObject(SQL_GET_TOP_CATGID, int.class);
		c_id = c_id + 1;
		System.out.println(c_id + "Category_id\n");

		return jdbcTemplate.update(SQL_INSERT_CATEGORY, c_id, catg.getPrct_title(), catg.getPrct_desc()) > 0;
	}
	//method to get the all categories
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();

		categories=jdbcTemplate.query(SQL_GET_CATEGORIES,new CategoryRowMapper());

		return categories;
	}
}
