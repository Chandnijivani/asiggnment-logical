<%-- 
    Document   : index
    Created on : 9 Jan, 2017, 10:01:20 AM
    Author     : mtech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body>
        
        <h3>File Upload:</h3>
Select a file to upload: <br />
<form action="fileupload" method="post" enctype="multipart/form-data">
<input type="file" name="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
<br><br><br>
<input type="submit" value="uploadfile" />
</form>
    </body>
</html>
