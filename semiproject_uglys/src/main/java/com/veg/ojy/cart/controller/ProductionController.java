//package com.veg.ojy.cart.controller;
//
//import java.io.IOException;
//import java.rmi.ServerException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import svc.Action;
//
//@WebServlet("*.cart")
//public class ProductionController extends HttpServlet{
//	
//	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServerException, IOException, ServletException {
//		
//		req.setCharacterEncoding("UTF-8");
//		
//		/* 1. 요청 주소 파악 */		
//		String requestURI = req.getRequestURI();
//		String contextPath = req.getContextPath();		
//		String command = requestURI.substring(contextPath.length());
//
//		/* 2. 각 요청 주소의 매핑 처리 */
//		ActionForward forward = null;
//		Action action = null;
//		
//		//상품 장바구니 추가 요청
//		if (command.equals("/vegAdd.cart")) {
//			action = new ProductionCartAdd();
//			try {
//				forward = action.execute(req, resp);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//        
//        	/* 3. 포워딩 처리 */
//		if(forward != null) {
//			if(forward.isRedirect()) {
//				// redirect 방식
//				resp.sendRedirect(forward.getPath());
//			} else {
//				// forward 방식
//				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
//				dispatcher.forward(req, resp);
//			}// 장바구니 목록 페이지 요청
//			else if (command.equals("/mycart.do")) {
//			    action = new BookCartListAction();
//			    try {
//			        forward = action.execute(req, resp);
//			    } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			}// 주문하기 페이지 요청
//			else if (command.equals("/bookShippingCheckOut.ok")) {
//			    action = new BookShippingCheckOutAction();
//			    try {
//			        forward = action.execute(req, resp);
//			    } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			}
//		}
//	}
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServerException, IOException, ServletException {
//		doProcess(req, resp);
//	}
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServerException, IOException, ServletException {
//		doProcess(req, resp);
//	}
//}