package cafe.jjdev.mall.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.admin.vo.Category;

@Mapper
public interface CategoryMapper {
	public List<Category> selectCategoryList();
	public int insertCategory(Category category);
}
