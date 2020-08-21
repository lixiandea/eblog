package com.lixiande.leetcode;
class person{
    private String name;
    public person(String name){
        System.out.println("now i am init a new person");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class test {
    public  static void vallueCrossTest(int age , float weight){
        System.out.println("函数内的age 地址" + System.identityHashCode(age));
        System.out.println("函数内的weight 地址" + System.identityHashCode(weight));
        age = 33;
        weight = 89.5f;
        System.out.println("函数内改变的age 地址" + System.identityHashCode(age));
        System.out.println("函数内改变的weight 地址" + System.identityHashCode(weight));


    }

    public  static void personCrossTest(person p ){
        System.out.println("函数内的p 地址" + System.identityHashCode(p));
        p = new person("lixiang");
        System.out.println("函数内改变的p 地址" + System.identityHashCode(p));
    }
    public static void main(String[] args) {
        int age = 10;
        float weight = 10.01f;
        System.out.println("函数外的age 地址" + System.identityHashCode(age));
        System.out.println("函数外的weight 地址" + System.identityHashCode(weight));
        vallueCrossTest(age,weight);
        System.out.println("函数外改变的age 地址" + System.identityHashCode(age));
        System.out.println("函数外改变的weight 地址" + System.identityHashCode(weight));
        person p = new person("松哥哥");
        System.out.println(p.toString());
        System.out.println("函数外的p 地址" + System.identityHashCode(p));
        personCrossTest(p);
        System.out.println("函数外的改变后p 地址" + System.identityHashCode(p));
        System.out.println(p.toString());







    }
}
