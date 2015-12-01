<%-- 
    Document   : index
    Created on : Jun 25, 2015, 2:31:26 PM
    Author     : j.anaya.villagrana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h1>RESULTS</h1>
    <div id="id01"></div>

    <script>
                
        function myFunction(response) {
            var arr = JSON.parse(response);
            var i;
            var out = "<table>";

            for (i = 0; i < arr.length; i++) {
                out += "<tr><td>" +
                        arr[i].profileId +
                        "</td></tr><tr><td>";
                for (j = 0; j < arr[i].matches.length; i++) {
                    out += arr[i].matches[j].profileId +
                        "</td><td>" +    
                        arr[i].matches[j].score + "</td></tr>";
                }
            }
            out += "</table>"
            document.getElementById("id01").innerHTML = out;
        }
    </script>
    myFunction(${message});
</body>
</html>
