package cafe.jjdev.mall.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;
import cafe.jjdev.mall.admin.vo.ProductCommonJoinCategory;

@Mapper
public interface ProductCommonMapper {
	//공통 상품 리스트 select join
	public List<ProductCommonJoinCategory> selectProductListByCategoryNo(Map<String, Object> map);
	//공통 상품 리스트 select join
	
	//상품과 공통상품의 select join
	public ProductCommon selectProductByProductCommonNo(int productCommonNo);
	//상품과 공통상품의 select join
	
	//공통 상품의 select 
	public ProductCommon selectProductByProductCommon(int productCommonNo);
	//공통 상품의 select
	
	//상품 리스트 select
	public List<Product> selectProductListByProductNo(int productCommonNo);
	//상품 리스트 select
	
	//공통 상품 리스트의 페이징을 위한 select count(*)
	public int selectProductCommonCount(Map<String, Object> map);
	//공통 상품 리스트의 페이징을 위한 select count(*)
	
	//공통 상품 insert
	public int insertProductCommon(ProductCommon productCommon);
	//공통 상품 insert
	
	//상품 insert
	public int insertProduct(Product product);
	//상품 insert
	
	//상품 상세보기 select
	public Product selectProductByProductNo(int productNo);
	//상품 상세보기 select
	
	//상품 재고량 update
	public int updateProductStock(Product product);
	//상품 재고량 update
}
