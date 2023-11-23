package com.veg.kth.admin.community.controller;

import java.io.File;
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
import com.veg.kth.admin.community.service.AdminCommunityService;
import com.veg.kth.community.model.dto.Category;
import com.veg.kth.community.model.dto.Material;
import com.veg.kth.community.model.dto.Procedure;
import com.veg.kth.community.model.dto.Recipe;

/**
 * Servlet implementation class AdminCommunityRecipeModifyEndServlet
 */
@WebServlet("/admin/recipewriteend")
public class AdminCommunityRecipeModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommunityRecipeModifyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("시스템 오류 발생");
		}else {
			
			String path = getServletContext().getRealPath("/upload/");
			path+="recipe";
			File dir=new File(path);
			if(!dir.exists()) dir.mkdir();
			MultipartRequest mr = new MultipartRequest(request,path,1024*1024*100,"UTF-8",
					new DefaultFileRenamePolicy());
			
			int recipeNo=0;
			if(mr.getParameter("recipe_no")!=null) {
				recipeNo = Integer.parseInt(mr.getParameter("recipe_no"));				
			}else {
				recipeNo = 0;
			}
			String oriMainFile = mr.getOriginalFileName("recipe_main_file");
			//System.out.println(oriMainFile);
			
			String renameMainFile = mr.getFilesystemName("recipe_main_file");
			String title = mr.getParameter("recipe_title");
			String explain = mr.getParameter("recipe_explain");
			String leadtime = mr.getParameter("leadtime");
			String category_dept1 = mr.getParameter("category_dept1");
			String category_dept2 = mr.getParameter("category_dept2");
			int member_no = Integer.parseInt(mr.getParameter("member_no"));
			
			Category category = Category.builder()
								.categoryDept1(category_dept1)
								.categoryDept2(category_dept2)
								.build();
			String[] hashtags = mr.getParameterValues("hashtag");
			
			
//			for(int i=0; i<hashtags.length;i++) {
//				System.out.println(hashtags[i]);
//			}
			
			
//			List<Hashtag> hashtag = (List<Hashtag>)Hashtag.builder()
//									.hashtagValue(hashtags)
//									.build();

			
			int capacity = Integer.parseInt(mr.getParameter("capacity"));
			
			String[] materialType = mr.getParameterValues("material_type");
			for(int i=0; i<materialType.length;i++) {
				materialType[i]=materialType[i].toUpperCase();
			}
			
			String[] materialName = mr.getParameterValues("material_name");
			String[] materialCapa = mr.getParameterValues("material_capa");
			

			List<Material> materials = new ArrayList<>();
			
			for(int i=0;i<materialType.length;i++) {
			    Material m = Material.builder() 
			    		.materialType(materialType[i])
			    		.materialName(materialName[i])
			    		.materialCapa(materialCapa[i])
			    		.build();
			    materials.add(m);
			}
			

			
			
			String[] procedureComment = mr.getParameterValues("procedure_comment");
			String procedureOriFile = mr.getOriginalFileName("procedure_file");
			String procedureRenameFile = mr.getFilesystemName("procedure_file");
			
			List<Procedure> procedures = new ArrayList<>();
			
			for(int i=0;i<procedureComment.length;i++) {
			    Procedure p = Procedure.builder()
			    		.procedureOrder((long)(i+1))
			    		.procedureComment(procedureComment[i])
			    		.build();
			    procedures.add(p);
			}
			
			
				
			Recipe r = Recipe.builder().build();
			if(member_no!=0 && recipeNo!=0) {
			r = Recipe.builder()
					.recipeNo(recipeNo)
					.recipeOriginalFileName(oriMainFile)
					.recipeRenamedFileName(renameMainFile)
					.recipeTitle(title)
					.recipeComment(explain)
					.recipeLeadTime(leadtime)
					.category(category)
//					.Hashtag(hashtag)
					.recipeCapa(capacity)
					.material(materials)
					.procedure(procedures)
					.recipeDate(null)
					.member_no(member_no)
					.build();
			
			}

			int result = new AdminCommunityService().updateRecipe(r);

			
			String msg, loc;
			
			if(result>0) {
				//입력성공
				msg = "레시피 수정 성공";
				loc = "/admin/recipeList.do";
			}else {
				//입력실패
				msg="레시피 수정 실패";
				loc="/admin/recipeList.do";
				File delFile = new File(path+"/"+renameMainFile);
				if(delFile.exists()) delFile.delete();
				
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			request.getRequestDispatcher("/views/common//msg.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
