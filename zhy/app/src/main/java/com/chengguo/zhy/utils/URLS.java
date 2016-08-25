package com.chengguo.zhy.utils;

/**
 * Created by Administrator on 2016/5/25.
 */
public class URLS {
    public static  String TOKEN="";

    public static final String PREFIX="http://sl.fangx2.net/";
    //---------------登录---------------
    public static final String LOGIN="appapi/api.php?op=json&a=login";

    //---------------客户列表---------------
    public static final String KEHUHLEIBIAO="appapi/api.php?op=json&m=customers&a=list";

    //---------------新建客户、意向等级---------------
    public static final String DENGJI="appapi/api.php?op=json&m=customer_set_up&token=";
    //---------------新建客户---------------
        public static final String XINJIANKEHU="appapi/api.php?op=json&m=customers&a=new&token=";
    //---------------客户详情---------------
    public static final String KEHUXIANGQING="appapi/api.php?op=json&m=customers&a=view&token=";
    //---------------客户信息修改---------------
    public static final String XIUGAI="appapi/api.php?op=json&m=customers&a=edit&token=";

    //---------------客户信息修改---------------
    public static final String BAIWENLEIBIAO="appapi/api.php?op=json&m=article&a=list&token=";


}

