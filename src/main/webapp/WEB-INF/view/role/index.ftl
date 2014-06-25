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

					  	   <input type="submit" value=" 搜索 "/>
					  	   <#if authUtil.hasAuth(8)>   <input type="button" onclick="window.open('${staticServer}/role/noadd')" value="新增角色"/></#if>

	
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
                <th>角色名</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>备注</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            	<#list roleList as role>
	            	<tr>
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${role.id}</td>
	                <td><a href="${staticServer}/userrole/findUserRole?id=${role.id}" title="title">${role.name}</a></td>
	                <td>${role.gmtCreate?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${role.gmtModified?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${role.description}</td>
	                <td>
	                  <!-- Icons -->
	                 <#if authUtil.hasAuth(7)>     <a href="${staticServer}/role/findbyid?id=${role.id}" title="Edit"><img src="${staticServer}/images/icons/pencil.png" alt="Edit" /></a> </#if>
	                <#if authUtil.hasAuth(6)>     <a href="${staticServer}/role/delete?id=${role.id}" title="Delete"><img src="${staticServer}/images/icons/cross.png" alt="Delete" /></a></#if>
	                 <#if authUtil.hasAuth(15)>   <a href="${staticServer}/role/config?roleId=${role.id}"  title="Edit Meta"><img src="${staticServer}/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </#if>  
	                   </td>
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
					  		<@q.pager pageNo=pageNo pageSize=pageSize recordCount=recordCount toURL="${staticServer}/role/rolelist"/>
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