package com.tuanshop.bb;


import java.util.Date;  

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;


 class MemCachedManager {  
  public static void main(String[] age){
      MemCachedClient client=new MemCachedClient();  
      String [] addr ={"127.0.0.1"};  
      Integer [] weights = {3};  
      SockIOPool pool = SockIOPool.getInstance();  
      pool.setServers(addr);  
      pool.setWeights(weights);  
      pool.setInitConn(5);  
      pool.setMinConn(5);  
      pool.setMaxConn(200);  
      pool.setMaxIdle(1000*30*30);  
      pool.setMaintSleep(30);  
      pool.setNagle(false);  
      pool.setSocketTO(30);  
      pool.setSocketConnectTO(0);  
      pool.initialize();  
        
//    String [] s  =pool.getServers();  
      client.setCompressEnable(true);  
      client.setCompressThreshold(1000*1024);  
        
//    将数据放入缓存  
      client.set("test2","test2");  
        
//    将数据放入缓存,并设置失效时间  
      Date date=new Date(2000000);  
      client.set("test1","test1", date);  
        
//    删除缓存数据  
//    client.delete("test1");  
        
//    获取缓存数据  
      String str =(String)client.get("test1");  
      System.out.println(str);  
  }  
} 