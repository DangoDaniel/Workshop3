<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
    <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
      <i class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
  </div>

  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Szczegóły użytkownika</h6>
    </div>
    <div class="card-body">

      <form action="/user/show" method="post">

        <table class="table">
          <tbody>

          <tr>
            <td>Id</td>
            <td>${user.id}</td>
          </tr>

          <tr>
            <td>Nazwa użytkownika</td>
            <td>${user.userName}</td>
          </tr>

          <tr>
            <td>Email</td>
            <td>${user.email}</td>
          </tr>
          <tr>

          </tr>
          </tbody>

        </table>


        <button type="submit" name="buttonList" value="showList" class="btn btn-primary">Zamknij</button>

      </form>


      </div>
    </div>
  </div>
</div>

<%@ include file="/footer.jsp" %>
</body>

</html>