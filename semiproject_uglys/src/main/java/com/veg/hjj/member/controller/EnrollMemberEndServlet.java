package com.veg.hjj.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.veg.hjj.member.dto.Member;
import com.veg.hjj.member.security.PasswordEncoder;
import com.veg.hjj.member.service.MemberService;

/**
 * Servlet implementation class EnrollMemberEndServlet
 */
@WebServlet(name="EnrollMemberEndServlet",urlPatterns="/member/enrollMemberEnd.do")
public class EnrollMemberEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * if(!ServletFileUpload.isMultipartContent(request)) {
		 * System.out.println("잘못된 접근입니다"); }else {
		 */
	         String path = request.getServletContext().getRealPath("/upload/photo");
	         int maxSize= 1024*1024*100;
	         String encoding = "UTF-8";
	         DefaultFileRenamePolicy dfr= new DefaultFileRenamePolicy();
	         
	         MultipartRequest mr = new MultipartRequest(request,path,maxSize,encoding,dfr);
		
		
		request.setCharacterEncoding("UTF-8");
		String memberId = mr.getParameter("memberId");
		String memberPw = mr.getParameter("memberPw");
		String memberName = mr.getParameter("memberName");
		String memberAge = mr.getParameter("ageRange");
		String memberEmail = mr.getParameter("email");
		int memberPhone = Integer.parseInt(mr.getParameter("phone")); // 수정된 부분
		String address = mr.getParameter("address"); 
		String addressDetail = mr.getParameter("address_detail"); 
			address+=addressDetail ;
		String acceptAgree = mr.getParameter("ckbox1");
		String serviceAgree = mr.getParameter("ckbox2");
		String marketingAgree = mr.getParameter("ckbox3");
		String photoRegist = mr.getFilesystemName("photoRegist");
		
		PasswordEncoder pe=new PasswordEncoder((HttpServletRequest)request);
		
		
		//PasswordEncoder pe=new PasswordEncoder();
		//System.out.println(pe.getSHA512(memberPw));
	
		List<String> addressList = new ArrayList<>();
		addressList.add(address);
		//String addressString = addressList.stream()
		   
		      //  .collect(Collectors.joining(","));
		Member m = Member.builder()
		        .memberId(memberId)
		        .memberPw(pe.getSHA512(memberPw))
		        .memberName(memberName)
		        .memberAge(memberAge)
		        .memberEmail(memberEmail)
		        .memberPhone(memberPhone)
		        .address(addressList)
		        .acceptAgree(acceptAgree)
		        .serviceAgree(serviceAgree)
		        .marketingAgree(marketingAgree)
		        .photoRegist(photoRegist)
		  
		        .build();
		
		
		int result=new MemberService().insertMember(m);
		//System.out.println(m);
		String msg,loc;
		if(result>0) {
			msg=m.getMemberName()+"님 회원가입 축하드립니다.!";
			loc="/";
		}else {
			msg="회원가입 실패했습니다, 다시 시도해주세요.";
			loc="/member/enrollmember.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/member/msg.jsp")
		.forward(request, response);
	      //}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
