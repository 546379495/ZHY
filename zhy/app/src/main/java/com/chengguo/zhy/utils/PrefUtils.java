package com.chengguo.zhy.utils;

import android.content.Context;
import android.content.SharedPreferences;

/*
*
*   本地文件 存取工具类
*
* */
public class PrefUtils {

    //本地文件名
      public static final String PREF_NAME="config";
      /**
     * @param ctx  上下文对象
     * @param key  要获取的数据名（键）
     * @param defaultValue 默认返回值
     * @return 
     *         
     *      获取SharedPreferences中指定布尔值的方法
     */
    public static boolean getBoolean(Context ctx,String key,boolean defaultValue){
    	  SharedPreferences sp=ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
  		return sp.getBoolean(key, defaultValue);
      }
    
    /**
     * @param ctx  上下文对象
     * @param key  要获取的数据名（键）
     * @param Value  要设置的值
     *
     *         设置一个boolean值
     */
    public static void setBoolean(Context ctx,String key,boolean Value){
  	  SharedPreferences sp=ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
		 sp.edit().putBoolean(key, Value).commit();
    }
    
    /**
     * @param ctx  上下文
     * @param key  键
     * @param defaultValue 默认值
     * @return
     *
     *     获取一个已储存的字符串
     */
    public static String getString (Context ctx,String key,String  defaultValue){
    	 SharedPreferences sp=ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
    	
    	return sp.getString(key, defaultValue);
    }
    
    /**
     * @param ctx 上下文
     * @param key 键
     * @param Value 值
     *
     *             设置一个字符串
     */
    public static void setString (Context ctx,String key,String  Value){
   	 SharedPreferences sp=ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
    	sp.edit().putString(key, Value).commit();
   }
    
}
