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
@WebServlet("/image/upload")
@MultipartConfig
public class RegisterProductionCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProductionCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Part filePart = request.getPart("upload");
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String ext = originalFileName.substring(originalFileName.indexOf("."));
        String newFileName = UUID.randomUUID().toString() + ext;

        String realPath = request.getServletContext().getRealPath("/upload"); 
        String savePath = realPath + "/" + newFileName;
        String uploadPath = request.getContextPath() + "/upload/" + newFileName;
 
        

        File fileSaveDir = new File(realPath + "upload/");
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
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


