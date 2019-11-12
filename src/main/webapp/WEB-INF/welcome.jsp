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
            Hello ${user.getLogin()} ! Your session is active
        </div>

    <c:choose>
        <c:when test = "${empList.size() == 0}">
            <font color="red">The company has ${empList.size()} employee!</font>
        </c:when>
        <c:otherwise>
            <form method='post' action="Controller">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Sel</th>
                            <th scope="col">Name</th>
                            <th scope="col">First name</th>
                            <th scope="col">Home phone</th>
                            <th scope="col">Mobile phone</th>
                            <th scope="col">Work phone</th>
                            <th scope="col">Address</th>
                            <th scope="col">Postal Code</th>
                            <th scope="col">City</th>
                            <th scope="col">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${empList}" var="employee">

                        <tr> 

                            <th scope="row"><div class="form-check"><input class="form-check-input" type="radio" name="employeeID" id="exampleRadios1" value=${employee.id} checked></div></th>
                            <td>  ${employee.name}</td>
                            <td>  ${employee.firstname}</td>
                            <td>  ${employee.telhome}</td>
                            <td>  ${employee.telmob}</td>
                            <td>  ${employee.telpro}</td>
                            <td>  ${employee.adress}</td>
                            <td>  ${employee.postalcode}</td>
                            <td>  ${employee.city}</td>
                            <td>  ${employee.email}  </td>
                        </tr> 
                    </c:forEach>
                    </tbody>
                </table>
                <input type='submit' name="action" value="Details"/>
                <c:if test = "${user.login == 'admin'}">
                    <input type='submit' name="action" value="Add"/>
                    <input type='submit' name="action" value="Delete"/>
                </c:if>
                <button type='submit' name='action' value='Logout'><span class="glyphicon glyphicon-off"></span></button>

            </form>
        </c:otherwise>


    </c:choose>
</body>
</html>