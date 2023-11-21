//package com.veg.ojy.cart.controller;
//
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////import vo.ActionForward;
//import com.veg.ojy.cart.dto.*;
//public class CartCheckOut {
//
//		@Override
//		public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//
//			req.setCharacterEncoding("UTF-8");
//			
//			/* URL로 넘어온 파라미터 저장 */
//			String c_session = req.getParameter("c_session");
//
//			ArrayList<Cart> cartList = null;
//			int totalMoney = 0;		// 지불해야 하는 총금액
//			int money = 0;			// 장바구니 항목 하나에 대한 지불 금액
//			
//			/* 요청 파라미터와 비교해 세션에 저장된 장바구니 목록 가져오기 */
//			HttpSession session = req.getSession(false);
//			if(session != null) {
//				// 세션이 생성되어 있는 경우
//				if(session.getId().equals(c_session)) {
//					// 브라우저의 세션Id와 세션쿠키가 동일한 경우(같은 브라우저의 경우)
//					cartList = (ArrayList<Cart>) session.getAttribute("cartList");
//					for(int i=0; i<cartList.size(); i++) {
//						money = cartList.get(i).getPrice() * cartList.get(i).getCount();
//						totalMoney += money;
//					}
//				} else {
//					// 같은 세션Id 아닌 경우
//					session.invalidate();
//					
//					resp.setCharacterEncoding("utf-8");
//					PrintWriter out = resp.getWriter();
//					out.print("<script>");
//					out.print("alert('서로 다른 브라우저입니다.');");
//					out.print("location.href='/bookShopMain.ok';");
//					out.print("</script>");
//					out.close();
//				}
//			} else {
//				// 세션이 생성되지 않은 경우
//				resp.setCharacterEncoding("utf-8");
//				PrintWriter out = resp.getWriter();
//				out.print("<script>");
//				out.print("alert('잘못된 접근입니다.');");
//				out.print("location.href='/bookShopMain.ok';");
//				out.print("</script>");
//				out.close();
//			}
//			
//			/* 포워딩할 때 가져갈 정보 저장 
//			 * 총금액을 request 영역에 속성으로 공유
//			 * .ok -> .jsp : forward
//			 * */
//			req.setAttribute("totalMoney", totalMoney);
//			
//			ActionForward forward = new ActionForward();
//			forward.setPath("/views/order/orderdetail.jsp");
//			forward.setRedirect(false);
//
//			return forward;
//		}
//}
