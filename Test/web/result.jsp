<%@page import="java.util.*" %>
<%@page import="etu2051.framework.modele.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title> FrontServlet </title>
</head>
<body>
	<h1> La redirection fonctionne </h1>
	<% ArrayList<Test> listTest = (ArrayList<Test>) request.getAttribute("listTest"); 
        for (int i=0; i<listTest.size(); i++) 
		{ %>
            <h5>
                <span> <%= listTest.get(i).getInput1() %> </span>
                <span> <%= listTest.get(i).getInput2() %> </span>
            </h5>
    <% } %>
</body>
</html>