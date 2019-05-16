package cafe.jjdev.mall.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.admin.service.ProductService;
import cafe.jjdev.mall.admin.vo.Category;
import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//상품리스트 출력 시작
	@GetMapping("/product/productList")
	public String getProductList(Model model
			,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
			,@RequestParam(value="categoryNo", required = false, defaultValue = "0") int categoryNo
			,@RequestParam(value="searchWord", required = false, defaultValue = "") String searchWord) {
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("categoryNo", categoryNo);
		inputMap.put("currentPage", currentPage);
		inputMap.put("searchWord", "%" + searchWord + "%");
		Map<String, Object> map = productService.getProductCommonList(inputMap);
		System.out.println("공통 상품 리스트로 이동");
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentTenPage", map.get("currentTenPage"));
		model.addAttribute("lastTenPage", map.get("lastTenPage"));
		model.addAttribute("repetitionPage", map.get("repetitionPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("productCount", map.get("productCount"));
		model.addAttribute("category", map.get("categoryList"));
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("searchWord", searchWord);
		return "/product/productList";
	}
	//상품리스트 출력 종료
	
	//상품 상세정보 출력 시작
	@GetMapping("/product/getProduct")
	public String getProduct(Model model
			,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
			,@RequestParam(value="searchWord", required = false, defaultValue = "") String searchWord
			,@RequestParam(value="productCommonNo", required = true) int productCommonNo) {
		Map<String, Object> map = productService.getProductCommon(productCommonNo);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("productCommon", map.get("productCommon"));
		model.addAttribute("category", map.get("categoryList"));
		model.addAttribute("product",map.get("product"));
		return "/product/getProduct";
	}
	//상품 상세정보 출력 종료
	
	//공통 상품 추가 폼 시작
	@GetMapping("/product/addProductCommon")
	public String addProductCommon(Model model, HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			List<Category> categoryList = productService.getCategoryList();
			model.addAttribute("category", categoryList);
			return "/product/addProductCommon";
		}
	}
	//공통 상품 추가 폼 종료
	
	//공통 상품 추가 액션 시작
	@PostMapping("/product/addProductCommon")
	public String addProductCommon(ProductCommon productCommon, HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			productService.addProductCommon(productCommon);
			return "redirect:" + "/product/productList";
		}
	}
	//공통 상품 추가 액션 종료
	
	//상품 추가 폼 시작
	@GetMapping("/product/addProduct")
	public String addProduct(HttpSession session, Model model
							,@RequestParam(value="productCommonNo", required = true) int productCommonNo) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			model.addAttribute("productCommonNo", productCommonNo);
			return "/product/addProduct";
		}
	}
	//상품 추가 폼 종료
	
	//상품 추가 액션 시작
	@PostMapping("/product/addProduct")
	public String addProduct(Product product, HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			productService.addProduct(product);
			return "redirect:" + "/product/getProduct?productCommonNo=" + product.getProductCommonNo();
		}
	}
	//상품 추가 액션 종료
	
	//재고량 수정 폼 시작
	@GetMapping("/product/modifyProductStock")
	public String modifyProductStock(Model model, HttpSession session
									,@RequestParam(value="productNo", required = true) int productNo) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			Map<String, Object> map = productService.getProduct(productNo);
			model.addAttribute("product", map.get("product"));
			model.addAttribute("category", map.get("categoryList"));
			return "/product/modifyProductStock";
		}
	}
	//재고량 수정 폼 종료
	
	//재고량 수정 액션 시작
	@PostMapping("/product/modifyProductStock")
	public String modifyProductStock(Product product, HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			productService.modifyProductStock(product);
			System.out.println(product.getProductStock());
			return "redirect:" + "/product/getProduct?productCommonNo=" + product.getProductCommonNo();
		}
	}
	//재고량 수정 액션 종료
}
