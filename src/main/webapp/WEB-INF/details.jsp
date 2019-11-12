<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    </head>
    <body>
        <div align="right">
            Hello ${user.login} ! Your session is active
        </div>
        <h2>Details of employee: ${employee.firstname} ${employee.name}</h2>
        <form>
            <div class="form-group">
                
                ID <input type="number" readonly class="form-control-plaintext" name="id" value=${employee.id}>
                Name <input type="text" class="form-control" name="name" value=${employee.name}>
                First Name <input type="text" class="form-control" name="firstname" value=${employee.firstname}>
                Home phone <input type="text" class="form-control" name="telhome" value=${employee.telhome}>
                Mobile phone <input type="text" class="form-control" name="telmob" value=${employee.telmob}>
                Work phone <input type="text" class="form-control" name="telpro" value=${employee.telpro}>
                Address <input type="text" class="form-control" name="adress" value=${employee.adress}>
                Postal code <input type="text" class="form-control" name="postalcode" value=${employee.postalcode}>
                <div class="row">
                    <div class="col">
                        City <input type="text" class="form-control" name="city" value=${employee.city}>
                    </div>
                    <div class="col">
                        Email <input type="text" class="form-control" name="email" value=${employee.email}>
                    </div>
                  </div>
                </div>
            <input type='submit' name="action" value="Cancel"/>
            <c:if test = "${user.login == 'admin'}">
                <input type='submit' name="action" value="Save"/>
            </c:if>
            <button type='submit' name='action' value='Logout'><span class="glyphicon glyphicon-off"></span></button>
        </form>
    </body>
</html>