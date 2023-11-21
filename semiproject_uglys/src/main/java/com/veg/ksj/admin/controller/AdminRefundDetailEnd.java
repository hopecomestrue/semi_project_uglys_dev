package com.veg.ksj.admin.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.veg.ksj.order.model.service.OrderService;

/**
 * Servlet implementation class AdminRefundDetailEnd
 */
@WebServlet("/admin/refundDetailEnd.do")
public class AdminRefundDetailEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRefundDetailEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		
		//환불주문번호, 환불상태, 환불사유 값 받아오기
		long refundNo=Long.parseLong(request.getParameter("refundNo")); //환불주문번호
		String refundCheck=request.getParameter("refundCheck"); //환불상태 : 환불승인대기,환불승인완료,환불승인반려
		String refundReason=request.getParameter("refundReason"); //환불사유
		
		System.out.println(refundNo);
		System.out.println(refundCheck);
		System.out.println(refundReason);
		
		
		//환불승인완료시 아임포트 결제환불
		if(refundCheck.equals("환불승인완료")) {
			
			URL url = new URL("https://api.iamport.kr/payments/cancel");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			// 요청 방식을 POST로 설정
			conn.setRequestMethod("POST");
			
			// 요청의 Content-Type, Accept, Authorization 헤더 설정
			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "0134b4bc1f3702e4c65ce949f1097bab49bfa757");
			
			// 해당 연결을 출력 스트림(요청)으로 사용
			conn.setDoOutput(true);
			
			// JSON 객체에 해당 API가 필요로하는 데이터 추가.
			JsonObject json = new JsonObject();
			json.addProperty("merchant_uid", refundNo);
			json.addProperty("reason", refundReason);
			
			// 출력 스트림으로 해당 conn에 요청
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(json.toString());
			bw.flush();
			bw.close();
			
			// 입력 스트림으로 conn 요청에 대한 응답 반환
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			br.close();
			conn.disconnect();
			
			System.out.println("[결제 취소 완료] 주문 번호 : "+ refundNo);
			
			int result=new OrderService().updateRefundDetails(refundCheck,refundNo); //환불사유 추가
			if(result>0) System.out.println("DB 환불상태 변경 성공");
			else System.out.println("DB 환불상태 변경 실패");
			
		}else {
//			int result=new OrderService().updateRefundDetails(refundCheck,refundNo);
		}
		
		gson.toJson("",response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
