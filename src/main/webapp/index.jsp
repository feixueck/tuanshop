<%
 response.setStatus(301);
 response.setHeader( "Location", "/" );
 response.setHeader( "Connection", "close" );
%>
   