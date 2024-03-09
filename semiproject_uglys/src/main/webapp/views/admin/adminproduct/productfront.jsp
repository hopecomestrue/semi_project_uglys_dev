<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.veg.hjj.member.dto.Member"%>
<%@ page import="java.util.List,com.veg.pdw.production.model.dto.Production" %>

<%
	List<Production>productions=(List<Production>)request.getAttribute("productions");
	Member loginAdmin=(Member)session.getAttribute("loginMember");
%>

<%if(loginAdmin!=null&&loginAdmin.getAdminCheck().equals("Y")){ %>
<%@ include file="/views/admin/common/header.jsp" %>

<style>
    #sidebar {
        padding-top: 70px;
    }

    .table-wrapper table {
        width: 100%;
        margin: 0 auto;
        table-layout: fixed;
    }

    .table-wrapper table td {
        word-break: break-all;
        padding: 15px;
    }


    .datatable-input {
        display: inline-block;
        width: 80%;
        padding: 10px;
        margin-bottom: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        display: block;
        padding: 10px;
        font-size: 16px;
        color: white;
        background-color: #C8f498;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        background-color: #45a000;
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px;
    }
</style>

<body>

    <!-- Wrapper -->
    <div class="pcoded-main-container">
        <!-- Main -->
        <div class="pcoded-content">
            <div class="card">
            	<div class="card-header">
                        <h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">상품 등록</h1>
                    </div>
                    <div class="card-body">
                        <div class="datatable-wraooer datatable-loading no-footer sortable searchable fixed-colums">
                            <div class="datable-top">
                                <div class="datatable-dropdown">
                                    <div class="datatable-search">
                                        <!-- 새로운 입력 필드 -->
                                        <form action="<%=request.getContextPath()%>/searchProduction.do" method="post">
                                            <table>
                                                <tr >
                                                    <td>상품번호:</td>
                                                    <td><input class="datatable-input" type="text" name="product_no" ></td>
                                                    <td>상품명:</td>
                                                    <td><input class="datatable-input" type="text" name="product_name"></td>
                                                </tr>
                                                <tr>
                                                    <td>가격:</td>
                                                    <td><input class="datatable-input" type="number" name="price_start"></td>
                                                    <td>~</td>
                                                    <td><input class="datatable-input" type="number" name="price_end"></td>
                                                </tr>
                                                <tr>
                                                    <td>재고:</td>
                                                    <td><input class="datatable-input" type="number" name="stock_start"></td>
                                                    <td>~</td>
                                                    <td><input class="datatable-input" type="number" name="stock_end"></td>
                                                </tr>
                                                <tr>
                                                    <td>생산지:</td>
                                                    <td><input class="datatable-input" type="text" name="production_place"></td>
                                                </tr>
                                            </table>
                                            <div><button type="submit" style="margin-bottom: 30px; margin-top: 30px;">검색</button></div>
                                        </form>

                                        <div style="display: flex; justify-content: flex-end; align-items: center;">
                                            <a href="<%=request.getContextPath() %>/admin/productregi.do">
                                                <button style="margin-right: 10px; padding: 5px 10px; margin-bottom: 30px;">상품등록</button>
                                            </a>

                                            <button onclick="sendValuesToServer(checkedValues);" style="margin-right: 10px; padding: 5px 10px; margin-bottom: 30px;" id="delete">상품삭제</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="features">
                            <div class="table-wrapper">
                                <table class="table table-hover" style="font-size: 12px;">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>상품번호</th>
                                            <th>상품명</th>
                                            <th>재배환경</th>
                                            <th>생산지</th>
                                            <th>가격</th>
                                            <th>재고</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <script>
                                        var checkedValues = [];
                                        window.onload = function() {
                                            var checkboxes = document.querySelectorAll('input[type="checkbox"]');


                                            checkboxes.forEach(function(checkbox) {
                                                checkbox.addEventListener('click', function() {
                                                    var production_no = this.parentNode.nextElementSibling.textContent;

                                                    if (this.checked) { // 체크박스가 체크된 경우
                                                        checkedValues.push(production_no); // 배열에 값을 추가
                                                    } else { // 체크박스가 해제된 경우
                                                        var index = checkedValues.indexOf(production_no);
                                                        if (index > -1) {
                                                            checkedValues.splice(index, 1); // 배열에서 값을 제거
                                                        }
                                                    }

                                                    console.log(checkedValues); // 현재 체크된 체크박스의 값들을 출력
                                                });
                                            });
                                        };

                                        function sendValuesToServer(checkedValues) {
                                            fetch('<%=request.getContextPath()%>/production/deletes.do', {
                                                    method: 'POST',
                                                    headers: {
                                                        'Content-Type': 'application/json',
                                                    },
                                                    body: JSON.stringify({
                                                        'checkedValues': checkedValues
                                                    }),
                                                })
                                                .then(response => response.json())
                                                .then(data => console.log(data))
                                                .catch((error) => {
                                                    console.error('Error:', error);
                                                });
                                            window.location.replace('<%=request.getContextPath()%>/admin/production.do');
                                        }
                                    </script>
                                    <tbody>
                                        <%if(productions!=null&&!productions.isEmpty()){ %>
                                        <%for(Production p : productions){%>
                                        <tr>
                                            <td><input type="checkbox" style="opacity: 1; -webkit-appearance: checkbox; -moz-appearance: checkbox; appearance: checkbox;"></td>
                                            <td><%=p.getProduction_no()%></td>
                                            <td><%=p.getProduction_name()%></td>
                                            <td><%=p.getEnvironment()%></td>
                                            <td><%=p.getPlace()%></td>
                                            <td><%=p.getPrice()%></td>
                                            <td><%=p.getStock()%></td>
                                            <td><%=p.getProduction_date()%></td>
                                        </tr>
                                        <% }
					       			 }					        
					       			 %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div id="pageBar" class="container">
                            
                            <%=request.getAttribute("pageBar") %>
                            
                        </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/views/admin/common/footer.jsp" %>
<%}%>
			