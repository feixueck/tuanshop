<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
 <link rel="stylesheet" href="${staticServer}/css/form.css" type="text/css" media="screen" />
 <script type="text/javascript" src="${staticServer}/scripts/form.js"></script>
<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
      		 <h3>更新用户</h3>
      		 <ul class="content-box-tabs">
		          <li><a href="#tab1" class="default-tab">Table</a></li>
		          <!-- href must be unique and match the id of target div -->
        	</ul>
        	<div class="clear"></div>
      </div>
      
        <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
           <#if flag?exists>
           		<#if flag==1>
           			<div class="notification success">
           		<#else>
           			<div class="notification error">
           		</#if>
           <#else>
           <div class="notification information">
           </#if> 
            <a href="#" class="close"><img src="${staticServer}/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
            <div> 
            	<#if flag?exists>
            		${msg}
            	<#else>
            		更新用户
            	</#if> 
            </div>
          </div>
          
         <form action="${staticServer}/authority/update" method="post"> 
         	<table>
         		<input type="hidden" name="id" value="${authorityinfo.id}"/>
				<tr> <td ><input name="name" value="${authorityinfo.name}" id="status"  type="text" placeholder="输入权限名字"/></td> </tr>
				<tr> <td><input name="description"value="${authorityinfo.description}" id="status"  type="text"placeholder="输入备注信息"/></td> </tr>
				<tr>
					<td>
						<input  class="btn5" type="button" onclick="window.open('${staticServer}/user/index','_self')" value="返回列表" />
						<input  class="btn5" type="submit" value="更新" />
					</td>
				<tr>
			<table>
		</form>
        </div>
        <!-- End #tab1 -->
      			
        <!-- End #tab2 -->
      </div>
</div>


      
</@layout.myLayout>