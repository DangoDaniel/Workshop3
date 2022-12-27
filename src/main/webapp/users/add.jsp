<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
      <i class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
  </div>

  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">

        <form action="/user/add" method="post">

        <label for="userName">Nazwa</label>
        <input name="userName" type="text" class="form-control" id="userName" placeholder="Nazwa użytkownika">
          <br>
        <label for="userEmail">Email</label>
        <input name="userEmail" type="email" class="form-control" id="userEmail" placeholder="Email użytkownika">
          <br>
        <label for="userPassword">Hasło</label>
        <input name="userPassword" type="password" class="form-control" id="userPassword" placeholder="Hasło użytkownika">
        <br>
        <button type="submit" class="btn btn-primary">Zapisz</button>


      </div>
    </div>
  </div>
</div>

<%@ include file="/footer.jsp" %>
</body>

</html>


