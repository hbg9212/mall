package cafe.jjdev.mall.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.admin.mapper.CategoryMapper;
import cafe.jjdev.mall.admin.vo.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public int addCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}
	
	public List<Category> getCategoryList() {
		return categoryMapper.selectCategoryList();
	}
}
