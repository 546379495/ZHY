package com.chengguo.zhy.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/19.
 */
public class StringsUtlis {

    /**
     * 是否是合法的手机号
     *
     * @param
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^1(3[0-9]|4[57]|5[0-9]|7[0678]|8[0-9])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 价钱转换成小数点后小字
     * @param s      要转换的数字
     * @param s1     字符串前需要添加的内容（￥）
     * @return   转换后的字符串
     */
    public static String initZiTi(String s,String s1){
        //tv.setText(Html.fromHtml("00.<small>88</small>"));（在setText中使用Html.fromHtml（））
        char[] arr=s.toCharArray();
        String ss=s1;
        for (int i = 0; i <arr.length ; i++) {
            ss+=arr[i];
            if (arr[i]=='.'){
                ss+="<small>";
            }
            if (i==arr.length-1){
                ss+="</small>";
            }


        }
        return ss;

    }

    /**
     * 把double类型数据保存小数点后两位
     * @param price
     * @return
     */
    public static String initDecimals(double price){

                DecimalFormat df=new DecimalFormat("#.00");
                return df.format(price);
            }

    /**
     * 把double类型数据保存小数点后两位
     * @param price
     * @return
     */
    public static String initDecimals(String price){
        double mPricr=Double.parseDouble(price);
        DecimalFormat df=new DecimalFormat("#.00");
        return df.format(mPricr);

    }

    /**
     * 时间戳转成yyyy-M-d各式
     * @param time
     * @return
     */
    public static String initTime(String time){
        if (time==null){
            return time;
        }

        long l=Long.parseLong(time)*1000;
        return new SimpleDateFormat("yyyy-M-d").format(new Date(l));
    }

}
