package com.veg.pdw.production.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class RegisterProductionCont
 */
@WebServlet("/upload/production/review")
@MultipartConfig
public class RegisterProductionReviewContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterProductionReviewContent() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Part filePart = request.getPart("upload");
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String ext = originalFileName.substring(originalFileName.indexOf("."));
        String newFileName = UUID.randomUUID().toString() + ext;

        // 저장 경로를 "/upload/production/content"로 변경하였습니다.
        String realPath = request.getServletContext().getRealPath("/upload/production/review"); 
        String savePath = realPath + "/" + newFileName;
        String uploadPath = request.getContextPath() + "/upload/production/review/" + newFileName;
 
        // 디렉토리를 생성하는 부분도 "/upload/production/content"로 변경하였습니다.
        File fileSaveDir = new File(realPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();  // 여러 단계의 디렉토리를 한 번에 생성하려면 mkdirs()를 사용합니다.
        }

        File file = new File(savePath);
        filePart.write(savePath);

        PrintWriter out = response.getWriter();
        out.print("{");
        out.print("\"uploaded\": true,");
        out.print("\"url\": \"" + uploadPath + "\"");
        out.println("}");
    }
}



