<%@ page import="java.util.*,entity.book.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">

    <title>도서 검색</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="list.html">도서검색</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          </ul>

          <form action="list" method="post" class="navbar-form navbar-right">
            <input type="text"  name="keyword" class="form-control" placeholder="Search...">
            <input type="submit" value="도서검색"> 
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">도서입력</a></li>
            <li><a href="#">도서삭제</a></li>
            <li><a href="#">도서수정</a></li>
            <li><a href="#">도서검색</a></li>
            <li><a href = "cart">장바구니 확인</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="addCart" method="post">
          <h2 class="sub-header">장바구니 목록</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  
                  <th>책 이미지</th>
                  <th>책 제목</th>
                  <th>책 저자</th>
                  <th>책 ISDN</th>
                  <th>책 가격</th>
                  
                </tr>
              </thead>
              <tbody>
              <%
              	ArrayList<BookEntity> list = (ArrayList<BookEntity>)request.getAttribute("MYKEY");
    			for(BookEntity tmp : list) {
              	
              %>
                <tr>
                  <td><img src=<%= tmp.getBimgurl() %> width=70></td>
                  <td><%= tmp.getBtitle() %></td>
                  <td><%= tmp.getBauthor() %></td>
                  <td><%= tmp.getBisdn() %></td>
                  <td><%= tmp.getBprice() %></td>
                </tr>
              <%
    			}
              %>  
              </tbody>
            </table>  
          </div>
       	</form>
        </div>
      </div>
    </div>
  </body>
</html>
    