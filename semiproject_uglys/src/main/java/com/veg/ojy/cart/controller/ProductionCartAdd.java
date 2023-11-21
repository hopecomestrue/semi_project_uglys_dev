//
//import java.net.URLEncoder;
//import java.util.ArrayList;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.veg.ojy.cart.service.*;
////import vo.ActionForward;
//import com.veg.pdw.production.*;
//import com.veg.pdw.production.model.dto.Production;
//import com.veg.ojy.cart.*;
//import com.veg.ojy.cart.dto.Cart;
//
///** 장바구니 담기 요청을 처리하는 Action 클래스*/
//public class ProductionCartAdd implements Action {
//
//	private HttpSession session;
//	
//	@Override
//	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//
//		/* 장바구니 항목으로 추가될 책 상품의 아이디와 마지막 페이지를 파라미터 값으로 받아온다 */
//		int b_id = Integer.parseInt(req.getParameter("b_id"));
//		int nowPage = Integer.parseInt(req.getParameter("page"));
//		
//		
//		/* DB 접근이 필요한 비즈니스 로직 호출
//		 * 장바구니 항목으로 추가될 책 상품 정보를 얻어오는 메서드 호출
//		 * */
//		CartService service = new CartService();
//		Production cartProduction = service.getProductionCart(production_name);
//		
//		/* 책 상품을 장바구니 항목으로 추가하는 메서드 호출 
//		 * 세션 영역 객체에 장바구니 항목을 추가해야 하므로 파라미터 값으로 request 객체를 던진다. */
//		addCart(req, cartProduction, b_id);		
//		
//		/* 세션ID 쿠키로 만들어 브라우저에 넘겨주기 
//		 * 생성한 쿠키의 유효 기간 : 24H(60*60*24)*/
//		Cookie c_session = new Cookie("c_session", URLEncoder.encode(session.getId(), "UTF-8")); 
//		c_session.setMaxAge(60*60*24);
//		resp.addCookie(c_session);
//		
//		/* 포워딩
//		 * .ok -> .ok : redirect
//		 * */
//		ActionForward forward = new ActionForward();
//		forward.setPath("/?page="+nowPage+"&b_id="+b_id);
//		forward.setRedirect(true);
//
//		return forward;
//	}
//	
//	/** 책 상품을 장바구니 항목으로 추가하는 메서드
//	 *  세션 영역 객체에 장바구니 항목을 추가해야 하므로 파라미터 값으로 request 객체를 던진다.
//	 */
//	@SuppressWarnings("unchecked")
//	public void addCart(HttpServletRequest req, Production cartProduction, int b_id) {
//
//		session = req.getSession(true);
//		ArrayList<Cart> s_cartList = (ArrayList<Cart>) session.getAttribute("cartList");
//		
//		if(s_cartList == null ) {
//			s_cartList = new ArrayList<>();
//			session.setAttribute("cartList", s_cartList);
//		}
//		
//		// 지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 판단하는 변수
//		// 기본값 true로 하여 요청에서 지정한 항목이 처음으로 추가되는 장바구니 항목으로 지정되게 한다.
//		boolean isNewCart = true;	
//		
//		/* 새로 추가하는 장바구니 항목인지에 따른 처리
//		 * 새로 추가할 장바구니 항목이 기존 장바구니 항목 목록에 존재하는 경우
//		 * 1. 기존에 존재하는 장바구니 항목일 때 isNewCart = false
//		 * 2. 기존 장바구니 항목의 수량을 하나 증가 
//		 * */
//		for(int i=0; i<s_cartList.size(); i++) {
//			if(cartProduction.getProduction_name() == s_cartList.get(i).getProduction_name()) {
//				isNewCart = false;
//				s_cartList.get(i).setCount(s_cartList.get(i).getCount()+1);
//				break;
//			}
//		}
//		
//		/* 새로 추가하는 장바구니 항목인지에 따른 처리
//		 * 새로 추가할 장바구니 항목이 기존 장바구니 항목 목록에 존재하지 않는 경우
//		 * 1. 장바구니 항목을 저장하는 cartList에 새로운 Cart 객체 추가
//		 * */
//		if(isNewCart) {
//			Cart cart = new Cart();
//			cart.setC_b_id(b_id);
//			cart.setC_b_name(cartBook.getB_name());
//			cart.setC_b_image(cartBook.getB_image());
//			cart.setC_b_catgy(cartBook.getB_catgy());
//			cart.setC_b_price(cartBook.getB_price());
//			cart.setC_b_qty(1);
//			
//			s_cartList.add(cart);
//		}
//	}
//
//}