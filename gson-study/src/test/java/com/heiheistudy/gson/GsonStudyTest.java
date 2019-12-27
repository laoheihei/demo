package com.heiheistudy.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author llc
 * @description
 * @date 2019/12/27 15:50
 */
public class GsonStudyTest {
    private Gson gson = new Gson();

    @Test
    /**
     * 一、基本数据类型的 [解析] 与 [生成]
     */
    public void parseBasicType() {
        String intStr = "100";
        
        String doubleStr = "\"99.99\"";
        // String doubleStr = "99.99";
        String booleanStr = "true";
        String stringStr = "string";

        // 一、基本数据类型的 [解析]
        Gson gson = new Gson();
        // 100
        Integer integer = gson.fromJson(intStr, int.class);
        // 99.99
        Double aDouble = gson.fromJson(doubleStr, double.class);
        // true
        Boolean aBoolean = gson.fromJson(booleanStr, boolean.class);
        // string 
        String s = gson.fromJson(stringStr, String.class);

        Assert.assertEquals(true, 100 == integer);
        assertEquals(true, aDouble.equals(99.99d));
        assertEquals(true, aBoolean);
        assertEquals("string", s);

        // 二、基本数据类型的 [json化]
        // 100
        String aIntegerJsonStr = gson.toJson(integer);
        // true
        String aDoubleJsonStr = gson.toJson(aDouble);
        // 99.99
        String aBooleanJsonStr = gson.toJson(aBoolean);
        // \"string\"
        String aStringJsonStr = gson.toJson(s);

        Assert.assertEquals("100", aIntegerJsonStr);
        assertEquals("true", aBooleanJsonStr);
        assertEquals("99.99", aDoubleJsonStr);
        /* notice! */
        assertEquals("\"string\"", aStringJsonStr);
    }

    @Test
    public void parseEntity() {
        User tom = new User("tom", 24, "lalala@123.com");
        Gson gson = new Gson();
        String jsonUser = gson.toJson(tom);
        String standardJsonString = "{\"name\":\"tom\",\"age\":24,\"emailAddress\":\"lalala@123.com\"}";
        String nonStandardJsonString = "{\"name\":\"tom\",\"age\":24,\"email\":\"lalala@123.com\"}";
        /* 注意@SerializedName.value */
        assertNotEquals(standardJsonString, jsonUser);
        assertEquals(nonStandardJsonString, jsonUser);
        /* 注意@SerializedName.alternate */
        User user = gson.fromJson(standardJsonString, User.class);
        assertEquals("lalala@123.com", user.getEmailAddress());
    }

    @Test
    /**
     * 泛型
     */
    public void testGeneric() {
        String jsonArrayStr = "[\"Android\",\"Java\",\"PHP\"]";
        /* 匿名类 */
        TypeToken<List<String>> typeToken = new TypeToken<List<String>>() {};
        System.out.println(typeToken.getType().getTypeName());

        List<String> o = gson.fromJson(jsonArrayStr, typeToken.getType());
    }


    @Data
    public static class User {
        private String name;
        private Integer age;
        /* 序列化为jsonString时，[emailAddress]的key为value字段指定值，即"email" */
        /* 反序列化为 User 时，jsonObject中key = "email_address" 或 "emailAddress" 都可映射到 User.emailAddress字段 */
        @SerializedName(value = "email", alternate = {"email_address", "emailAddress"})
        private String emailAddress;

        public User(String name, Integer age, String emailAddress) {
            this.name = name;
            this.age = age;
            this.emailAddress = emailAddress;
        }

        public User() {
        }
    }

}