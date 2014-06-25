<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>

<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
      		 <h3>Content box</h3>
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
            <div> This is a Content Box. You can put whatever you want in it. By the way, you can close this notification with the top-right cross. </div>
          </div>
          <div id="search">
			  	<form name="myForm" action="${staticServer}/role/rolelist" method="post">
					<table border="1" width="650px" align="center">
					  <tr>
					  	  <td>
					  	    名字:<input type="text" name="rolename" value="${RequestParameters.rolename}"/>
					  	   <input type="submit" value=" 搜索 "/> <input type="button" onclick="window.open('${staticServer}/role/noadd')" value="新增用户"/>
					  	  </td>
                           
					  </tr>
					   
					  	   
                       
				   </table>
				</form>
  			</div>
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>ID</th>
                <th>用户名</th>
                <th>权限名</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>备注</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            	<#list userroleList as userrole>
	            	<tr>
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${userrole.id}</td>
	                <td>${userrole.userId}</td>
	                <td>${userrole.roleId}</td>
	                <td>${userrole.gmtCreate?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${userrole.gmtModified?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${userrole.description}</td>
	                <td>
	                  <!-- Icons -->
	               <!--   <a href="${staticServer}/role/findbyid?id=${userrole.id}" title="Edit"><img src="${staticServer}/images/icons/pencil.png" alt="Edit" /></a> <a href="${staticServer}/role/delete?id=${userrole.id}" title="Delete"><img src="${staticServer}/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="Edit Meta"><img src="${staticServer}/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>-->
	              </tr>
            	 </#list>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="bulk-actions align-left">
                    <select name="dropdown">
                      <option value="option1">操作...</option>
                      <option value="option2">Edit</option>
                      <option value="option3">Delete</option>
                    </select>
                    <a class="button" href="#">应用</a> </div>
                   
                     <div id="pager">
  						<#import "layout/pager.ftl" as q>
					  		<#if recordCount?exists>
					  		<@q.pager pageNo=pageNo pageSize=pageSize recordCount=recordCount toURL="${staticServer}/userrole/findUserRole"/>
					  		</#if>
   					 </div>
                 
                  <!-- End .pagination -->  
                  <div class="clear"></div>
                </td>
              </tr>
             
            </tfoot>
          </table>
        </div>
        <!-- End #tab1 -->
      
        <!-- End #tab2 -->
      </div>
</div>

</@layout.myLayout>