package com.veg.seoj.cscenter.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/inquiry/openAI.do")
public class OpenAIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenAIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        request.setAttribute("jsonBody", jsonBody);



        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println("{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"carousel\":{\"type\":\"basicCard\",\"items\":[{\"title\":\"보물상자\",\"description\":\"보물상자 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자2\",\"description\":\"보물상자2 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]},{\"title\":\"보물상자3\",\"description\":\"보물상자3 안에는 뭐가 있을까\",\"thumbnail\":{\"imageUrl\":\"https://t1.kakaocdn.net/openbuilder/sample/lj3JUcmrzC53YIjNDkqbWK.jpg\"},\"buttons\":[{\"action\":\"message\",\"label\":\"열어보기\",\"messageText\":\"짜잔! 우리가 찾던 보물입니다\"},{\"action\":\"webLink\",\"label\":\"구경하기\",\"webLinkUrl\":\"https://e.kakao.com/t/hello-ryan\"}]}]}}]}}");
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



    private String extractJsonString(HttpServletRequest request) throws IOException {
        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
        }
        return jsonStringBuilder.toString();
    }
}
