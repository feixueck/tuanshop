<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>自定义信息窗体</title> 
<!-- 页面布局样式 --> 
<link rel="stylesheet" type="text/css" href="http://developer.amap.com/Public/css/demo.Default.css" />  
<script language="javascript" src="http://webapi.amap.com/maps?v=1.2&key=9d8cbfb3ed04aebad04231281c2930c8"></script> 
<script language="javascript"> 
var mapObj,toolBar; 
//初始化地图对象，加载地图 
function mapInit(){ 
    mapObj = new AMap.Map("iCenter",{center:new AMap.LngLat(116.481181,39.989792),level:13}); 
    //地图中添加地图操作ToolBar插件 
    mapObj.plugin(["AMap.ToolBar"],function(){       
        toolBar = new AMap.ToolBar();  
        mapObj.addControl(toolBar);      
    }); 
        
    //地图初始化时，在地图上添加一个marker标记,鼠标点击marker可弹出自定义的信息窗体 
    addMarker();     
} 
//添加marker标记 
function addMarker(){ 
   mapObj.clearMap(); 
   var marker = new AMap.Marker({                     
   map:mapObj,                    
   position:new AMap.LngLat(116.481181,39.989792), //位置  
   icon:"http://webapi.amap.com/images/0.png" //复杂图标        
   });  
   AMap.event.addListener(marker,'click',function(){ //鼠标点击marker弹出自定义的信息窗体 
         infoWindow.open(mapObj,marker.getPosition());   
   });   
} 
    
//实例化信息窗体 
var infoWindow = new AMap.InfoWindow({ 
        isCustom:true,  //使用自定义窗体 
        content:createInfoWindow('方恒假日酒店  <span style="font-size:11px;color:#F00;">价格:318</span>',
"<img src='http://tpc.googlesyndication.com/simgad/5843493769827749134' style='float:left;margin:0 5px 5px 0;'>地址：北京市朝阳区阜通东大街6号院3号楼 东北 8.3 公里<br/>电话：010 64733333<br/><a href='http://baike.baidu.com/view/6748574.htm'>详细信息</a>"), 
        size:new AMap.Size(300, 0), 
        offset:new AMap.Pixel(0, -50)//-113, -140 
    }); 
    
//构建自定义信息窗体  
function createInfoWindow(title,content){ 
    var info = document.createElement("div"); 
    info.className = "info"; 
    // 定义顶部标题 
    var top = document.createElement("div"); 
    top.className = "info-top"; 
      var titleD = document.createElement("div"); 
      titleD.innerHTML = title; 
      var closeX = document.createElement("img"); 
      closeX.src = "http://webapi.amap.com/images/close2.gif"; 
      closeX.onclick = closeInfoWindow; 
          
    top.appendChild(titleD); 
    top.appendChild(closeX); 
    info.appendChild(top); 
    // 定义中部内容 
    var middle = document.createElement("div"); 
    middle.className = "info-middle"; 
    middle.innerHTML = content; 
    info.appendChild(middle); 
        
    // 定义底部内容 
    var bottom = document.createElement("div"); 
    bottom.className = "info-bottom"; 
    var sharp = document.createElement("img"); 
    sharp.src = "http://webapi.amap.com/images/sharp.png"; 
    bottom.appendChild(sharp);   
    info.appendChild(bottom); 
    return info; 
} 
    
//关闭信息窗体 
function closeInfoWindow(){ 
    mapObj.clearInfoWindow(); 
} 
    
</script> 
</head> 
<body onLoad="mapInit()">  
    <div id="iCenter"></div>     
    <div style="padding:2px 0px 0px 5px;font-size:12px">  
        点击地图上的点标记，打开所添加的自定义信息窗体 
    </div> 
 </div> 
</body> 
</html>  