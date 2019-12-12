package com.jdkstudy.regex;

import java.util.regex.Pattern;

/**
 * @author llc
 * @description
 * @date 2019/12/12 10:31
 */
public class RegexDemo {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 一、有用的正则表达式子集
    // 1、匹配
    // 0）todo "." 是否匹配 "\n"？
    // 1）特殊字符："?"、"\\d+"、"|"、"()"
    // 2）todo "\\W"、"\\w"：[a-zA-Z0-9]
    // 3）todo 2、string.split(): 将字符串从正则表达式匹配的地方切开 & （重载版本：限制字符串分割的次数）
    // 4）string.replaceAll() 、string.replaceFirst()
    // 5）字符："B" 、"\\n" 换行符 、"\\r" 回车 、"\\f" 换页 、"\\s" 空白符(空格、"\\t"、"\\n"、"\\r"、"\\f")
    // 6）todo 测试"\\s"对"\\n"、"\\r"、"\\f"的替换
    // 7）todo "\\xhh" = 16进制值为oxhh的字符   h代表[0-f]
    // 8）todo "\\uhhhh" = 16进制表示为oxhhhh的Unicode字符   h代表[0-f]
    // 9）todo (X) 捕获组 \\i引用第i个捕获组
    // todo 10）"^" 一行的起始
    // todo 11）"&" 一行的结束  字符串中带"\\n" 是匹配字符串的结束还是匹配"\\n"？
    // 12）todo "\\b" 词的边界 、"\\B" 非词的边界
    // 13）todo "\\G": 前一个匹配的结束

    // 2、量词
    // 1）贪婪：匹配最多  X? X+ X* X{n} X{n,} X{n,m}
    // 2）勉强：最少匹配 X?? X+? X*? X{n}? X{n,}? X{n,m}?
    // 3）占有  todo

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 二、Pattern and Matcher
    // 1、简介
    //     Pattern: 编译后的正则表达式 ； Matcher：正则表达式对输入字符串的匹配结果
    // 2、Matcher开启功能：matcher.find()
    //     todo Matcher.find(i)  i代表原字符串中的idx，Matcher.find(i)表示从 String s = originString.substring(i) 方法生成的字符串开始进行匹配
    // 3、组
    //     1）组0为整个表达式、组1为第一对括号括起的组
    //     2）group()返回前一次匹配的组0、group(i)返回前一次匹配的组i;
    //           如果组0匹配成功，但是指定的组i没有匹配输入字符串的任何部分，则将返回null
    //           start(int group)、end(int group)返回指定组在输入字符串中的起始索引 和 结束索引 + 1

    // 4、编译标记
    //




    public static void test() {
        String regex = "\\xhh";
        System.out.println(regex);
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
