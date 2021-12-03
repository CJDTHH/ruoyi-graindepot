package com.ruoyi.web.controller.common;

import com.ruoyi.common.mapper.SelectPrefixCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GetToken {

    @Autowired
    private SelectPrefixCode prefixCode;

    public static String buildToken(long timestamp, String data, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("3303000701002").append(timestamp).append("k7d3VPrzKJZAVX4nhBcBU5QB50knM26G").append(url);
        if (data != null) {
            sb.append(data);
        }
        String md5 = MD5(sb.toString());
        System.out.println(md5);
        return md5;
    }

    /**
     * 32位MD5加密的大写字符串
     *
     * @param s
     * @return
     */
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成ID
     *
     * @param id
     * @return
     */
    public String getContractId(String id) {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String timeNow = format.format(time);
        Integer idss = prefixCode.countNumber();
        StringBuffer buffer = new StringBuffer();
        buffer.append(id);
        buffer.append(timeNow);
        buffer.append(idss + 1);
        String ider = buffer.toString();
        return ider;
    }
}
