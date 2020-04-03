package com.example.demo;

import sun.util.resources.ga.LocaleNames_ga;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class lambda  {

    //静态方法，直接接口调用。跟普通的static方法是一样的，不需要实现类去调用
    static void print3(String message) {
        System.out.println(message);
    }
    public static String  test2(String tring)
    {
        System.out.println("ddddddd");
        return "ddddddd";
    }

    public static String  test1(String tring)
    {
        System.out.println("bbbbbbbbbbbb");
        return "bbbbbbbbbbbb";
        //list1.forEach(n -> {System.out.println(n); int dfdf= 1+1;});
        //test2(test1("mmmm"));
       // list1.forEach(n -> {System.out.println(n);  System.out.println("FFF");});

    }
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Lambda1", "Lambda3", "Lambda2");
        Stream Stream1= list1.stream();
        Stream Streamparallel= list1.parallelStream();

        //Stream1.forEach(System.out::println);
        //Long count=Stream1.filter(l -> l.toString()=="Lambda1").count();
        //System.out.println(count);

        //Stream1.limit(1).forEach(System.out::println);

        //Stream1.sorted().forEach(System.out::println);

       //List<String> listt = list1.stream().sorted().limit(3).collect(Collectors.toList());

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 8, 2);
//
//        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
//
//        System.out.println("列表中最大的数 : " + stats.getMax());
//        System.out.println("列表中最小的数 : " + stats.getMin());
//        System.out.println("所有数之和 : " + stats.getSum());
//        System.out.println("平均数 : " + stats.getAverage());

        //List<String> collect = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> collect = list1.stream().map(a->a+"tangtang").collect(Collectors.toList());
        System.out.println(collect);
    }


    public static void main1(String[] args) {


        //final如果不写的话，Lambda表达式会默认该变量为final
        final String string="Hello ";

        HelloWorld test = (String message)->System.out.println(message+"World!");
        test.print(string);
    }
    @FunctionalInterface
    interface HelloWorld {
        void print(String str);
        default void print2() {

        }
    }

}







