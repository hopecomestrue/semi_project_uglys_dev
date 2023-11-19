<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/animate.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/magnific-popup.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/aos.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/ionicons.min.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/jquery.timepicker.css">


    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/css/icomoon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jycss/css2/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.ckeditor.com/ckeditor5/40.0.0/classic/ckeditor.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>


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

        #slideShow {
            width: 100%;
            height: 300px;
            overflow: hidden;
            position: relative;
        }

        #slideShow img {
            position: absolute;
            width: 100%;
            height: 100%;
            display: none; // 모든 이미지를 처음에는 숨김
        }

        @keyframes slideShow {
            0% {
                left: 0%;
                opacity: 1;
            }

            11.11% {
                left: -100%;
                opacity: 1;
            }

            22.22% {
                left: -200%;
                opacity: 1;
            }

            22.23% {
                left: -300%;
                opacity: 1;
            }

            33.34% {
                left: -400%;
                opacity: 1;
            }

            44.45% {
                left: -500%;
                opacity: 1;
            }

            44.46% {
                left: -600%;
                opacity: 1;
            }

            55.57% {
                left: -700%;
                opacity: 1;
            }

            66.68% {
                left: -800%;
                opacity: 1;
            }

            66.69% {
                left: -900%;
                opacity: 1;
            }

            77.8% {
                left: -1000%;
                opacity: 1;
            }

            88.91% {
                left: -1100%;
                opacity: 1;
            }
        }

        #pageBar {
            display: flex;
            justify-content: start;
            gap: 10px;
        }

        #pageBar button.active {
            background-color: #777;
        }

        .ck.ck-editor {
            width: 100%;
            max-width: 1000px;
            margin: 0 auto;
        }

        .ck-editor__editable {
            height: 200vh;
        }
    </style>
</head>

<body class="is-preload">

    <!-- Wrapper -->
    <div id="wrapper">
        <!-- Main -->
        <div id="main">
            <div class="inner">
                <header>
                    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
                        <div class="container">
                            <a class="navbar-brand" href="index.html">채소랑</a>
                            <!-- 메인화면으로 이동 // 주소바꾸기 -->
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="oi oi-menu"></span> Menu
                            </button>

                            <div class="collapse navbar-collapse" id="ftco-nav">
                                <ul class="navbar-nav ml-auto">
                                    <li class="nav-item"><a href="#" class="nav-link">Home</a></li>
                                    <li class="nav-item"><a href="#" class="nav-link">채소농장</a></li>
                                    <li class="nav-item"><a href="#" class="nav-link">커뮤니티</a></li>
                                    <li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
                                    <li class="nav-item"><a href="/mypage.html" class="nav-link">관리자페이지</a></li>
                                    <li class="nav-item cta cta-colored"><a href="/cart1.html" class="nav-link"><span href=""></span>[0]</a></li>

                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>
                <!-- Banner -->
                <section id="banner">
                    <div class="content">
                        <header>
                            <h2>상품등록<br />
                            </h2>
                        </header>
                    </div>
                </section>

                <!-- Section -->
                <section>
                    <header class="major">
                        <h2>상품개별페이지</h2>
                    </header>

                    <div style="display: flex;">
                        <img id="preview" style="width: 360px; height: 360px;">

                    <form action="<%=request.getContextPath()%>/production/register.do" method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td>상품명:</td>
                                <td><input type="text" id="product-name" name="production_name"></td>
                            </tr>
                            <tr>
                                <td>원가:</td>
                                <td><input type="number" id="original-price" name="production_price"></td>
                            </tr>
                            <tr>
                                <td>할인율:</td>
                                <td><input type="number" id="discount-rate" name="production_discount"></td>
                            <tr>
                                <td>태그:</td>
                                <td><input type="text" id="tag" name="production_tag"></td>
                            </tr>
                           
                        </table>
                    </div>
                    <div style="display: block;">
                        <input type="file" id="file-input1" accept="image/*" multiple name="production_img1">
                    </div>
                    </section>
                        <div>
                            <hr style="margin-top: 15px; margin-bottom: 15px">
                        </div>

                        <header class="major">
                            <div style="margin-top: 300px; margin-bottom: 300px;"></div>
                            <h2>상품상세페이지</h2>
                        </header>
                        <div style="display: flex; align-items: flex-start;">
                            <div style="display: flex; flex-direction: column; align-items: center;">
                                <div id="slideShow" style="width: 360px; height: 360px;">
                                    <!-- 이미지는 JavaScript로 동적으로 추가 -->
                                </div>
                                <input type="file" id="file-input2" accept="image/*" multiple name="production_img2">
                            </div>
                            <div id="display-area" style="font-size: 20px;">
                                <!-- 값출력란 -->
                            </div>
                        </div>

                        <div id="pageBar">
                            <!-- 페이지 버튼은 JavaScript로 동적으로 추가 -->
                        </div>

                        <div style="margin-top: 30px; margin-bottom: 30px;">
                            <label for="farming-environment">재배환경:</label>
                            <input type="text" id="farming-environment" name="production_environment">
                            <label for="production-area" >생산지:</label>
                            <input type="text" id="production-area" name="production_place">
                            <label for="production-stock" >재고:</label>
                            <input type="number" id="production-stock" name="production_stock">
                        </div>

                        <h2>상품상세설명</h2>
                        <div id="editor"></div>
                        <div style="display: block;">
                            <button onclick="upload();" style="margin-top: 100px;" id="upload">등록</button>
                            <input type="hidden" value="" name="content" id="upload">
                 	</form>
                   </div>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/js/jyjs/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jyjs/js/browser.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jyjs/js/breakpoints.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jyjs/js/util.js"></script>
    <script src="<%=request.getContextPath() %>/js/jyjs/js/main.js"></script>


    <script>
        function confirmLogout() {
            var result = confirm("로그아웃 하시겠습니까?");
            if (result) {
                alert("로그아웃 되었습니다.");
            } else {
                alert("로그아웃 취소되었습니다.");
            }
        }
    </script>
    <script>
        var productNameInput = document.getElementById('product-name');
        var tagInput = document.getElementById('tag');
        var originalPriceInput = document.getElementById('original-price');
        var discountRateInput = document.getElementById('discount-rate');

        productNameInput.addEventListener('input', displayValues);
        tagInput.addEventListener('input', displayValues);
        originalPriceInput.addEventListener('input', displayValues);
        discountRateInput.addEventListener('input', displayValues);

        function displayValues() {
            var productName = productNameInput.value;
            var tag = tagInput.value;
            var originalPrice = originalPriceInput.value;
            var discountRate = discountRateInput.value;

            var displayArea = document.getElementById('display-area');
            displayArea.innerHTML =
                '상품명: ' + productName + '<br>' +
                '원가: ' + originalPrice + '<br>' +
                '할인율: ' + discountRate + '<br>' +
                '태그: ' + tag;
        }
    </script>

    <script>
        document.querySelector('#file-input2').addEventListener('change', function(e) {
            slideShow = document.getElementById('slideShow');
            pageBar = document.getElementById('pageBar');

            for (let i = 0; i < this.files.length; i++) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    var img = document.createElement('img');
                    img.src = e.target.result;
                    img.style.display = 'none'; // 처음에는 모든 이미지를 숨김
                    slideShow.appendChild(img);

                    // 페이지 버튼 추가
                    var btn = document.createElement('button');
                    btn.textContent = slideShow.querySelectorAll('img').length;
                    let index = slideShow.querySelectorAll('img').length - 1;
                    btn.addEventListener('click', function() {
                        goToSlide(index);
                    });
                    pageBar.appendChild(btn);

                    // 첫 이미지 보이기
                    if (slideShow.querySelectorAll('img').length === 1) {
                        goToSlide(0);
                    }
                }
                reader.readAsDataURL(this.files[i]);
            }
        });

        function goToSlide(index) {
            var slides = slideShow.querySelectorAll('img');
            var dots = pageBar.querySelectorAll('button');
            for (let i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
                dots[i].classList.remove("active");
            }
            slides[index].style.display = "block";
            dots[index].classList.add("active");
        }
    </script>

    <script>
        document.querySelector('#file-input1').addEventListener('change', function(e) {
            var slideShow = document.getElementById('slideShow');
            var pageBar = document.getElementById('pageBar');
            var preview = document.getElementById('preview');
            var reader = new FileReader();

            reader.onload = function(e) {
                preview.src = e.target.result;

                var img = document.createElement('img');
                img.src = e.target.result;
                img.style.display = 'none'; // 처음에는 모든 이미지를 숨김
                slideShow.appendChild(img);

                // 페이지 버튼 추가
                var btn = document.createElement('button');
                btn.textContent = slideShow.querySelectorAll('img').length;
                let index = slideShow.querySelectorAll('img').length - 1;
                btn.addEventListener('click', function() {
                    goToSlide(index);
                });
                pageBar.appendChild(btn);

                // 첫 이미지 보이기
                if (slideShow.querySelectorAll('img').length === 1) {
                    goToSlide(0);
                }
            }

            reader.readAsDataURL(this.files[0]);
        });
    </script>

    <script>
        var editor;
        ClassicEditor
            .create(document.querySelector('#editor'), {
                ckfinder: {
                    uploadUrl: '<%=request.getContextPath()%>/image/upload'
                }
            })
            .then(e => {
                editor = e;
                console.log('Editor was initialized');
            })
            .catch(error => {
                console.error(error);
            });

        function upload() {
            const editorData = editor.getData();
            /* console.log(editorData); */
            $("#upload").attr("value", editorData);
            $("#upload").submit();

        }
    </script>
</body>

</html>