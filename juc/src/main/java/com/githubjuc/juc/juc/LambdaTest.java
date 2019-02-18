package com.githubjuc.juc.juc;

@FunctionalInterface
interface Foo{
    //    public void say();
    public int add(int x,int y);
    public default int mul(int x,int y){
        return x*y;
    }
    public static int div(int x,int y){
        return x/y;
    }
}
public class LambdaTest {
    public static void main(String[] args) {
//        Foo foo = () -> {
//            System.out.println("Hello");
//        };
//        foo.say();
        Foo foo=(int x,int y)->{
            System.out.println("come in");
            return x+y;
        };
        System.out.println(foo.add(3,4));
        System.out.println(foo.mul(2,3));
        System.out.println(Foo.div(9,3));
    }
}

