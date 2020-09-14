package net.htwater.springtest.util;

/**
* 类  名：Person
* 描  述：人员
* <p>
* 功能一：人员信息类
*
* @author ShenHaiyun no.HT151 软件部移动组
* @date
*/
public class Person {
    private String name;
    private int age;
    public String sex;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Deprecated
    public void eat(){
        System.out.println("eat...");
    }

    public void eat(String  food){
        System.out.println("eat "+food);
    }

    @Override
    @SuppressWarnings({})
    /**
     * @author shy
     * @param null
     */
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
