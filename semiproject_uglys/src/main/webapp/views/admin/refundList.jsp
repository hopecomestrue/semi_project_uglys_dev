<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/common/header.jsp" %>

 <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }

      .bd-mode-toggle {
        z-index: 1500;
      }

      .bd-mode-toggle .dropdown-menu .active .bi {
        display: block !important;
      }
      
      .admin-title{
        color: black;
        text-decoration: none;
      }

      .search_3{
        align-items: center;
        display: flex;
        justify-content: right;
        margin-right: 10%;
      }

      #refund-check{
        width: 18%;
        margin-left: 70%;
        margin-bottom: 3%;
      }

      .refund-tb{
        width: 80%;
        margin: 0 auto;
      }

      .refund-paging{
        margin: 5%;
      }
      
    </style>

<body>
<div>
  <h1 style="text-align: center; margin-top: 5%; margin-bottom: 5%;">환불 현황</h1>
</div>
<div class="refund-check">
  <select class="form-select form-select-lg" aria-label=".form-select-lg example" id="refund-check">
    <option selected>대기중</option>
    <option value="1">승인</option>
    <option value="2">거부</option>
  </select>
</div>
<div class="refund-tb">
<table class="table table-bordered">
    <tr>
      <th><input class="form-check-input" type="checkbox" id="checkboxNoLabel" value="" aria-label="..."></th>
      <th>주문 상세 번호</th>
      <th>주문 아이디</th>
      <th>이름</th>
      <th>전화번호</th>
      <th>주소</th>
      <th>주문 날짜</th>
      <th>환불 사유</th>
      <th>승인 여부</th>
  </tr>
  <tr>
      <td><input class="form-check-input" type="checkbox" id="checkboxNoLabel" value="" aria-label="..."></td>
      <td><a href="">123456789</a></td>
      <td>admin123</td>
      <td>홍길동</td>
      <td>010-1234-1234</td>
      <td>서울시 금천구</td>
      <td>2023-11-10</td>
      <td>고객 단순 변심</td>
      <td>대기중</td>
  </tr>    
  </table>
</div>
<div class="search_3">
  <div>
<select class="form-select form-select-lm" aria-label="Small select example">
    <option value="1">주문아이디로 조회하기</option>
    <option value="2">주문번호로 조회하기</option>
    <option value="3">주소로 조회하기</option>
  </select>
</div>
<div>
  <input type="text" class="form-control" placeholder="내용을 적어주세요.">
</div>
<div>
  <button type="button" class="btn btn-primary">검색</button>
</div>
</div>

<nav aria-label="Page navigation example" class="refund-paging">
    <ul class="pagination justify-content-center">
      <li class="page-item disabled">
        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">이전</a>
      </li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item"><a class="page-link" href="#">4</a></li>
      <li class="page-item"><a class="page-link" href="#">5</a></li>
      <li class="page-item">
        <a class="page-link" href="#">다음</a>
      </li>
    </ul>
  </nav>


</main>
<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  
<%@ include file="/views/admin/common/footer.jsp" %>