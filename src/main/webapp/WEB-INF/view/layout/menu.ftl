<!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h2 id="sidebar-title"><a href="#">聚优惠</a></h2>
    
       
      <!-- Sidebar Profile links -->
      <div id="profile-links"> Hello, <a href="#" title="Edit your profile">865171</a>, you have <a href="#messages" rel="modal" title="3 Messages">3 Messages</a><br />
        <br />
        <a href="#" title="View the Site">View the Site</a> | <a href="#" title="Sign Out">Sign Out</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="#/" class="nav-top-item no-submenu">
          <!-- Add the class "no-submenu" to menu items with no sub menu -->
          Dashboard </a> </li>
        <li> <a href="#" <#if !menu?exists||menu==1>class="nav-top-item current"<#else>class="nav-top-item "</#if>>
          <!-- Add the class "current" to current menu item -->
          用户管理 </a>
          <ul>
            <li><a <#if curr==1>class="current"</#if>href="${staticServer}/user/index">用户列表</a></li>
            <li><a <#if curr==2>class="current"</#if> href="${staticServer}/role/rolelist">角色列表</a></li>
            <!-- Add class "current" to sub menu items also -->
            <li><a <#if curr==3>class="current"</#if>href="${staticServer}/authority/index">权限列表</a></li>
          </ul>
        </li>
        <li> <a href="#" <#if menu==2> class="nav-top-item current"<#else>class="nav-top-item"</#if>> 团购综合搜索 </a>
          <ul>
            <li><a <#if curr==4>class="current"</#if>href="${staticServer}/tuans/index">地图搜索</a></li>
            <li><a  href="#">Manage Pages</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 大众点评优惠 </a>
          <ul>
            <li><a href="#">Create a new Page</a></li>
            <li><a href="#">Manage Pages</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 团购优惠管理 </a>
          <ul>
            <li><a href="#">Upload Images</a></li>
            <li><a href="#">Manage Galleries</a></li>
            <li><a href="#">Manage Albums</a></li>
            <li><a href="#">Gallery Settings</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 银行卡优惠管理</a>
          <ul>
            <li><a href="#">Calendar Overview</a></li>
            <li><a href="#">Add a new Event</a></li>
            <li><a href="#">Calendar Settings</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> Settings </a>
          <ul>
            <li><a href="#">General</a></li>
            <li><a href="#">Design</a></li>
            <li><a href="#">Your Profile</a></li>
            <li><a href="#">Users and Permissions</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
      <div id="messages2" style="display: none">
        <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
        <h3>3 Messages</h3>
        <p> <strong>17th May 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>2nd May 2009</strong> by Jane Doe<br />
          Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>25th April 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <form action="#" method="post">
          <h4>New Message</h4>
          <fieldset>
          <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
          </fieldset>
          <fieldset>
          <select name="dropdown" class="small-input">
            <option value="option1">Send to...</option>
            <option value="option2">Everyone</option>
            <option value="option3">Admin</option>
            <option value="option4">Jane Doe</option>
          </select>
          <input class="button" type="submit" value="Send" />
          </fieldset>
        </form>
      </div>
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->