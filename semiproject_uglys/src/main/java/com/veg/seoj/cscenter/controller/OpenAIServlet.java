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
@WebServlet("/openAI.do")
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


/*
        System.out.println("dddddddddddd");
        String utterance = "";
        */



/*        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
        }

        // JSON 문자열 파싱
        JsonObject jsonObject = JsonParser.parseString(jsonStringBuilder.toString()).getAsJsonObject();

        // 특정 변수 확인
        if (jsonObject.has("yourVariable")) {
            String yourVariableValue = jsonObject.get("yourVariable").getAsString();
            // 여기에서 yourVariable에 대한 작업 수행
            System.out.println("Your Variable Value: " + yourVariableValue);
        }

        // 나머지 로직 수행...

        // 응답 보내기
        response.setContentType("text/plain");
        response.getWriter().write("Request processed successfully!");*/

/*
        String jsonString = extractJsonString(request);

        // JSON 문자열 출력 (테스트용)
        System.out.println("Received JSON: " + jsonString);

        // JSON 문자열을 사용하여 필요한 작업 수행

        // 응답 보내기 (예: 성공적으로 처리되었다는 메시지)
        response.setContentType("text/plain");
        response.getWriter().write("Request processed successfully!");*/







// Gson의 JsonParser를 사용하여 요청의 입력 스트림에서 직접 JSON 데이터를 JsonObject로 파싱합니다.
      /*  try (BufferedReader reader = request.getReader()) {
            *//*JsonObject jsonObject = JsonParser
                    .parseReader(reader)
                    .getAsJsonObject();*//*

            // JSON 객체에서 userRequest 객체를 가져옵니다.
//            JsonElement userRequestElement = jsonObject.get("userRequest");
     *//*       if (userRequestElement != null && userRequestElement.isJsonObject()) {
                JsonObject userRequest = userRequestElement.getAsJsonObject();

                // userRequest 객체에서 utterance 값을 가져옵니다.
                JsonElement utteranceElement = userRequest.get("utterance");
                if (utteranceElement != null && utteranceElement.isJsonPrimitive()) {
                    utterance = utteranceElement.getAsString();

                    // 가져온 utterance 값을 출력하거나 원하는 작업을 수행합니다.
                    System.out.println("발화 내용: " + utterance);
                } else {
                    System.out.println("utterance 값이 없거나 올바르지 않습니다.");
                }
            } else {
                System.out.println("userRequest 객체가 없거나 올바르지 않습니다.");
            }*//*

            // 응답을 전송합니다.
        } catch (Exception e) {
            // 예외가 발생한 경우에 대한 처리를 수행합니다.
            e.printStackTrace();
        }
*/



















            System.out.println(request);
        // 요청에서 JSON 데이터 추출
        String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        // JSON 데이터 출력 (테스트용)
        System.out.println("kakao");

        System.out.println(jsonBody);

        // 추출한 JSON 데이터를 다른 서블릿으로 포워딩
        request.setAttribute("jsonBody", jsonBody);
        /*        request.getRequestDispatcher("/inquirylist.jsp").forward(request, response);*/


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
        System.out.println(request);
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
