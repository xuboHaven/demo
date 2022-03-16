package com.example.demo.practice.newFeatures;

import com.example.demo.practice.common.TEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk8新特性1 - lambda表达式 ，函数式编程
 * 重点理解：何为lambda表达式；常见lambda表达式使用
 */
public class TLambda {

    /**
     * 函数内部类，创建新对象
     * @return
     */
    public Thread createNewThread(){
       return new Thread(()->{
            System.out.println(1);
        });
    }

    /**
     * 遍历对象，实现过滤
     */
    public static void traverse(List<String> a){
        a.forEach((x)-> System.out.println(x));
        a=a.stream().filter((x)->x.contains("o")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> ex = new ArrayList<>();
        ex.add("xubo");
        ex.add("huangjia");
        ex.add("two");
        ex.add("years");
        traverse(ex);
        traverse(ex);
        System.out.println(TEnum.RED.toString());

    }
}
