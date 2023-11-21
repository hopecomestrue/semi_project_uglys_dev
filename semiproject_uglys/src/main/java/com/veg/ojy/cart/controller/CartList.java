//package com.veg.ojy.cart.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.veg.ojy.cart.dto.Cart;
//import com.veg.pdw.production.model.dto.Production;
//
//public class CartList implements Action {
//
//    private HttpSession session;
//
//    @Override
//    public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        req.setCharacterEncoding("UTF-8");
//
//        // 세션에 저장된 장바구니 목록을 ArrayList 타입의 객체로 반환하는 메서드 호출
//        ArrayList<Cart> cartList = getCartList(req);
//
//        // 총금액 계산
//        int totalMoney = 0; // 지불해야 하는 총금액
//
//        if (cartList != null) {
//            for (int i = 0; i < cartList.size(); i++) {
//                Cart cartItem = cartList.get(i);
//
//                // Cart의 Production 리스트를 가져옴
//                List<Production> productionList = cartItem.getProductionList();
//
//                for (Production production : productionList) {
//                    // 각 Production 객체에서 필요한 정보를 가져와 사용
//                    double money = production.getPrice() * cartItem.getCount();
//                    totalMoney += money;
//                }
//            }
//        }
//
//        // 포워딩할 때 가져갈 정보 저장
//        // 총금액을 request 영역에 속성으로 저장
//        req.setAttribute("totalMoney", totalMoney);
//
//        ActionForward forward = new ActionForward();
//        forward.setPath("/book/bookCartList.jsp");
//        forward.setRedirect(false);
//
//        return forward;
//    }
//
//    // 세션에 저장된 장바구니 목록을 ArrayList 타입의 객체로 반환하는 메서드
//    @SuppressWarnings("unchecked")
//    public ArrayList<Cart> getCartList(HttpServletRequest req) {
//        ArrayList<Cart> s_cartList = null;
//        session = req.getSession(false);
//
//        if (session != null) {
//            // 세션이 생성되어 있는 경우
//            s_cartList = (ArrayList<Cart>) session.getAttribute("cartList");
//        }
//
//        return s_cartList;
//    }
//}