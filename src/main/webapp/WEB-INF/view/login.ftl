<head>
<title>Simpla Admin </title>
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
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>Simpla Admin</h1>
    <!-- Logo (221px width) -->
    <a href="#"><img id="logo" src="${staticServer}/images/logo.png" alt="Simpla Admin logo" /></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form action="/doLogin" method="post">
      <div class="notification information png_bg">
        <div> <#if msg?exists>${msg}<#else>Just click "Sign In". No password needed. </#if></div>
      </div>
      
      <p>
        <label>Username</label>
        <input class="text-input" type="text" onFocus="login()" name="username"/><span id="showError"></span>
      </p>
      <div class="clear"></div>
      <p>
        <label>Password</label>
        <input class="text-input" type="password" name="password" /><span></span>
      </p>
      <div class="clear"></div>
     
      <p>
        <label>Signcode</label>
        <input class="text-input" type="text" name="code" />
        &nbsp;&nbsp;<img src="${staticServer}/makeRandCode" class="text-input"  width=80 height=30 id="verifyCodeImage" onclick="changeImage()">
      </p>
    
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
        Remember me </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="Sign In" />
      </p>
    
    </form>

  </div>
  <!-- End #login-content -->
     
</div>
<!-- End #login-wrapper -->
</body>
<script type="text/javascript">

       function login(){
        var userName=$("#userName").val();
        var password=$("#password").val();
        var verifyCode=$("#verifyCode").val();
		var boo = false;
         if(userName==""&&userName==null) {
		   $("#showError").css("display","block");
		   $("#error").css("display","none");
           $("#showError").innerHTML("<font color='red'>帐号不能为空</font>");
		   $("#password").val("");
		   $("#verifyCode").val("");
		   $("#userName").focus();
	       boo = false;
         }
         else if(password==""){
		    $("#showError").css("display","block");
			$("#error").css("display","none");
		    $("#showError").html("<font color='red'>密码不能为空</font>");
		    $("#verifyCode").val("");
		    $("#password").focus();
		     boo = false;
         }
        
     	else if(verifyCode==""){
		     $("#showError").css("display","block");
			 $("#error").css("display","none");
			 $("#showError").html("<font color='red'>验证码不正确</font>");
			 $("#verifyCode").val("");
		     $("#verifyCode").focus();
			 boo = false;
		}
		else
		{
		  boo = true;
		}
		return boo;
    }


		
	//图片替换
	  function changeImage() {  
	       document.getElementById("verifyCodeImage").src="${request.contextPath}/makeRandCode?sid="+new Date().getTime();
	  }
  
    
</script>
</html>
