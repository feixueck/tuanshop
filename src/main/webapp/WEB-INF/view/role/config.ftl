<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
 <link rel="stylesheet" href="${staticServer}/css/form.css" type="text/css" media="screen" />
 <script type="text/javascript" src="${staticServer}/scripts/form.js"></script>
<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
      		 <h3>角色配置</h3>
      		 <ul class="content-box-tabs">
		          <li><a href="#tab1" class="default-tab">Table</a></li>
		          <!-- href must be unique and match the id of target div -->
        	</ul>
        	<div class="clear"></div>
      </div>
      
        <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <div class="notification attention png_bg"> <a href="#" class="close"><img src="${staticServer}/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
            <div> ${msg}This is a Content Box. You can put whatever you want in it. By the way, you can close this notification with the top-right cross. </div>
          </div>
          <div id="search">
					<table border="1" width="650px" align="center">
                       
				   </table>
				
  			</div>
          <table>
           <form name="myForm" action="${staticServer}/role/config-auth" method="post">
           	<input type="hidden" name="roleId" value="${role.id}"/>
            <h3> 角色:${role.name}</h3>
            <tbody>
            	<tr>
            	
            	<#list authList as auth> ··
            		 
            		 
	            	 <#if (auth_index+1)%4==0>
	                   <td><input type="checkbox" <#if alist?seq_contains(auth.id)>checked="checked"</#if> name="auths" value=${auth.id} />${auth.name}    </td></tr> <tr>
	                 	<#else>
	                    <td><input type="checkbox" <#if alist?seq_contains(auth.id)>checked="checked"</#if> name="auths" value=${auth.id} />${auth.name}   </td>
	               </#if>
            	 </#list>
            	 </tr>
         	   <tr>
            			<td><input  class="btn5" type="button" onclick="window.open('${staticServer}/role/rolelist','_self')" value="返回列表" /></td>
						<td><input  class="btn5" type="submit" value="提交配置" /> </td>
				</tr>
				
			  
            </tbody>
          </form>
          </table>
        </div>
        <!-- End #tab1 -->
      
        <!-- End #tab2 -->
      </div>
</div>

</@layout.myLayout>