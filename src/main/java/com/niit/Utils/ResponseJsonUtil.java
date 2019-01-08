package com.niit.Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class ResponseJsonUtil {
    /**
     * 默认字符编码
     */
    private static String encoding = "UTF-8";

    /**
     * JSONP默认的回调函数
     */
    private static String callback = "callback";

    /**
     * FastJSON的序列化设置
     */
    private static SerializerFeature[] features = new SerializerFeature[]{
            //输出Map中为Null的值
            SerializerFeature.WriteMapNullValue,

//            //如果Boolean对象为Null，则输出为false
//            SerializerFeature.WriteNullBooleanAsFalse,

            //如果List为Null，则输出为[]
            SerializerFeature.WriteNullListAsEmpty,

//            //如果Number为Null，则输出为0
//            SerializerFeature.WriteNullNumberAsZero,

            //输出Null字符串
            SerializerFeature.WriteNullStringAsEmpty,

            //格式化输出日期
            SerializerFeature.WriteDateUseDateFormat
    };

    /**
     * 把Java对象JSON序列化
     * @param obj 需要JSON序列化的Java对象
     * @return JSON字符串
     */
    private static String toJSONString(Object obj){
        return JSON.toJSONString(obj, features);
    }

    /**
     * 返回jackson JSON格式数据
     * @param response
     * @param data 待返回的Java对象
     * @param encoding 返回JSON字符串的编码格式
     */
    public static void json(HttpServletResponse response, Object data, String encoding){
        //设置编码格式
        response.setContentType("text/plain;charset=" + encoding);
        response.setCharacterEncoding(encoding);
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        PrintWriter out = null;
        try{
            String outJson = mapper.writeValueAsString(data);
            out = response.getWriter();
            out.write(outJson);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 返回Jackson JSON格式数据，使用默认编码 UTF-8
     * @param response
     * @param data 待返回的Java对象
     */
    public static void json(HttpServletResponse response, Object data){
        json(response, data, encoding);
    }

    /**
     * 返回JSON格式数据
     * @param response
     * @param data 待返回的Java对象
     * @param encoding 返回JSON字符串的编码格式
     */
    public static void allJson(HttpServletResponse response, Object data, String encoding){
        //设置编码格式
        response.setContentType("text/plain;charset=" + encoding);
        response.setCharacterEncoding(encoding);

        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.write(toJSONString(data));
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 返回JSON格式数据，使用默认编码 UTF-8
     * @param response
     * @param data 待返回的Java对象
     */
    public static void allJson(HttpServletResponse response, Object data){
        allJson(response, data, encoding);
    }

    /**
     * 返回JSONP数据，使用默认编码和默认回调函数
     * @param response
     * @param data JSONP数据
     */
    public static void jsonp(HttpServletResponse response, Object data){
        jsonp(response, callback, data, encoding);
    }

    /**
     * 返回JSONP数据，使用默认编码
     * @param response
     * @param callback JSONP回调函数名称
     * @param data JSONP数据
     */
    public static void jsonp(HttpServletResponse response, String callback, Object data){
        jsonp(response, callback, data, encoding);
    }

    /**
     * 返回JSONP数据
     * @param response
     * @param callback JSONP回调函数名称
     * @param data JSONP数据
     * @param encoding JSONP数据编码
     */
    public static void jsonp(HttpServletResponse response, String callback, Object data, String encoding){
        StringBuffer sb = new StringBuffer(callback);
        sb.append("(");
        sb.append(toJSONString(data));
        sb.append(");");

        // 设置编码格式
        response.setContentType("text/plain;charset=" + encoding);
        response.setCharacterEncoding(encoding);

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(sb.toString());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getEncoding() {
        return encoding;
    }

    public static void setEncoding(String encoding) {
        ResponseJsonUtil.encoding = encoding;
    }

    public static String getCallback() {
        return callback;
    }

    public static void setCallback(String callback) {
        ResponseJsonUtil.callback = callback;
    }
}