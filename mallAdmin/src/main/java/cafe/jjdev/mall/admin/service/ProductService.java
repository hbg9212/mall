package cafe.jjdev.mall.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.admin.mapper.CategoryMapper;
import cafe.jjdev.mall.admin.mapper.ProductCommonMapper;
import cafe.jjdev.mall.admin.vo.Category;
import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;
import cafe.jjdev.mall.admin.vo.ProductCommonJoinCategory;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductCommonMapper productCommonMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	//공통 상품 리스트 서비스 시작
	public Map<String, Object> getProductCommonList(Map<String, Object> map) {
		final int ROW_PER_PAGE = 10;
		int currentPage = (int)map.get("currentPage");
		final int BEGIN_ROW = (currentPage-1)*ROW_PER_PAGE;
		map.put("beginRow", BEGIN_ROW);
		map.put("rowPerPage", ROW_PER_PAGE);
		List<ProductCommonJoinCategory> list = productCommonMapper.selectProductListByCategoryNo(map);
		final int PRODUCT_COUNT = productCommonMapper.selectProductCommonCount(map);
		int currentTenPage = currentPage/10;
		if(currentPage%10 == 0) {
			currentTenPage--;
		}
		int lastPage = PRODUCT_COUNT/ROW_PER_PAGE;
		if(PRODUCT_COUNT%ROW_PER_PAGE !=0) {
			lastPage++;
		}
		int lastTenPage = lastPage/10;
		if(lastTenPage%10 == 0) {
			lastTenPage--;
		}
		int repetitionPage = 10;
		if((lastPage - currentTenPage*10) < 10) {
			repetitionPage = lastPage % 10 ;
		}		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Category> categoryList = categoryMapper.selectCategoryList();
		returnMap.put("list", list);
		returnMap.put("currentTenPage", currentTenPage);
		returnMap.put("lastTenPage", lastTenPage);
		returnMap.put("repetitionPage", repetitionPage);
		returnMap.put("productCount", PRODUCT_COUNT);
		returnMap.put("categoryList", categoryList);
		System.out.println("컨드롤러로 이동");
		return returnMap;
	}
	//공통 상품 리스트 서비스 종료
	
	//카테고리 리스트 서비스 시작
	public List<Category> getCategoryList(){
		return categoryMapper.selectCategoryList();
	}
	//카테고리 리스트 서비스 종료
	
	//공통 상품 입력 서비스 시작
	public int addProductCommon (ProductCommon productCommon) {
		return productCommonMapper.insertProductCommon(productCommon);
	}
	//공통 상품 입력 서비스 종료
	
	//상품 입력 서비스 시작
	public int addProduct (Product product) {
		return productCommonMapper.insertProduct(product);
	}
	//상품 입력 서비스 종료
	
	//공통 상품 상세보기 서비스 시작
	public Map<String, Object> getProductCommon(int productCommonNo) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Category> categoryList = categoryMapper.selectCategoryList();
		List<Product> product = productCommonMapper.selectProductListByProductNo(productCommonNo);
		ProductCommon productCommon = productCommonMapper.selectProductByProductCommon(productCommonNo);
		returnMap.put("categoryList", categoryList);
		returnMap.put("productCommon", productCommon);
		returnMap.put("categoryNo", productCommon.getProductCommonNo());
		returnMap.put("product", product);
		return returnMap;
	}
	//공통 상품 상세보기 서비스 시작
	
	//상품 상세보기 서비스 시작
	public Map<String, Object> getProduct(int productNo) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Product product = productCommonMapper.selectProductByProductNo(productNo);
		List<Category> categoryList = categoryMapper.selectCategoryList();
		returnMap.put("categoryList", categoryList);
		returnMap.put("product", product);
		return returnMap;
	}
	//상품 상베보기 서비스 종료
	
	//상품 재고량 업데이트 시작
	public void modifyProductStock(Product product) {
		productCommonMapper.updateProductStock(product);
	}
	//상품 재고량 업데이트 시작
}
