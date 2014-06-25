<#macro myLayout>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Simpla Admin</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="${staticServer}/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="${staticServer}/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="${staticServer}/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="${staticServer}/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="${staticServer}/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="${staticServer}/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="${staticServer}/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="${staticServer}/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="${staticServer}/scripts/jquery.date.js"></script>

</head>
<body>
<div id="body-wrapper">
  	<#include "layout/menu.ftl"/>
  
  <div id="main-content">
  	<#include "layout/header.ftl"/>
    <#nested/>
    <#include "layout/footer.ftl"/>
  </div>
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>

  
</#macro>