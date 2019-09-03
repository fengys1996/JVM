package _2019_8_31.BridgeMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 编译器什么时候会生成桥接方法
 * 子类继承或者实现一个父类或者接口的泛型方法时,在子类中明确的指定了泛型类型,
 * 那么编译时,编译器就会自动生成桥接方法(其他情况?)
 *
 * 为什么要生成桥接方法?
 *
 * java编译器会将所有非私有的方法编译为需要动态绑定的类型,因为父类的重载方法可能被子类重写
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }

    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data;    // Causes a ClassCastException to be thrown.
    }
}
