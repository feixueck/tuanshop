<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>

<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
      		 <h3>权限列表</h3>
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
			  	<form name="myForm" action="${staticServer}/user/index" method="post">
					<table border="1" width="650px" align="center">
					  <tr>
					  	  <td>
					  	 
					  	<#if authUtil.hasAuth(9)>     <input type="button" onclick="window.open('${staticServer}/authority/doAdd')" value="新增权限"/></#if>
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
                <th>权限名</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>备注说明</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            	<#list authorityrList as authority>
	            	<tr>
	                <td>
	                  <input type="checkbox" />
	                </td>
	                <td>${authority.id}</td>
	                <td>${authority.name}</td>
	                 <td>${authority.gmtCreate?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${authority.gmtModified?string("yyyy-MM-dd HH:mm:ss zzzz")}</td>
	                <td>${authority.description}</td>
	                <td>
	                  <!-- Icons -->
	                <#if authUtil.hasAuth(11)>   <a href="${staticServer}/authority/findauthId?id=${authority.id}", title="Edit"><img src="${staticServer}/images/icons/pencil.png" alt="Edit" /></a></#if>
	                  <#if authUtil.hasAuth(10)>   <a href="${staticServer}/authority/delete?id=${authority.id}" title="Delete"><img src="${staticServer}/images/icons/cross.png" alt="Delete" /></a></#if>
	                 
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
					  		<@q.pager pageNo=pageNo pageSize=pageSize recordCount=recordCount toURL="${staticServer}/authority/index"/>
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
 <div id="messages" style="display: none">
        <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
        <h2>新增用户</h2>
        <form action="#" method="post">
          <h4>用户名</h4>
          <fieldset>
          <input id="username" name="username" type="text" />
          </fieldset>
          <h4>密码</h4>
          <fieldset>
         <input id="userpwd" name="userpwd" type="password" />
          </fieldset>
          <h4>住址</h4>
          <fieldset>
          <input id="address" name="address" type="text" />
          </fieldset>
          <fieldset>
          <input class="button" type="submit" value="Send" />
          </fieldset>
        </form>
      </div>
     <div id="messages2" style="display: none">
		<h1>Registration process</h1>
		
		<form method="post" id="customForm" action="">
			<div>
				<label for="name">Name</label>
				<input id="name" name="name" type="text" />
				<span id="nameInfo">What's your name?</span>
			</div>
			<div>
				<label for="email">E-mail</label>
				<input id="email" name="email" type="text" />
				<span id="emailInfo">Valid E-mail please, you will need it to log in!</span>
			</div>
			<div>
				<label for="pass1">Password</label>
				<input id="pass1" name="pass1" type="password" />
				<span id="pass1Info">At least 5 characters: letters, numbers and '_'</span>
			</div>
			<div>
				<label for="pass2">Confirm Password</label>
				<input id="pass2" name="pass2" type="password" />
				<span id="pass2Info">Confirm password</span>
			</div>
			<div>
				<label for="message">Message</label>
				<textarea id="message" name="message" cols="" rows=""></textarea>
			</div>
			<div>
				<input id="send" name="send" type="submit" value="添加" />
			</div>
		</form>
	</div>
      
</@layout.myLayout>