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
 * java编译器会将所有非私有实例方法的调用都编译为需要动态绑定的类型,因为父类的重载方法可能被子类重写
 *
 * java虚拟机中的静态绑定: 在解析时,便能够直接识别目标方法的情况
 * java虚拟机中的动态绑定:需要在运行过程中,根据调用者的动态类型来识别目标方法的情况
 *
 * 对于invokestatic和invokespecial, java虚拟机能够直接识别到目标方法
 * 对于invokevirtual和invokeinterface, 虚拟机需要根据执行过程中,根据调用者的动态类型,来确定具体的目标方法
 *
 * java的Constant Pool里存着哪些东西?
 *
 * 在编译过程中,我们并不知道目标方法的具体地址, 因此, java编译器会暂时用符号引用来表示该目标方法.
 * 这一符号引用包括  目标方法所在的类或者接口的名字,  目标方法的方法名,  方法描述符.
 * 符号引用存储在class文件的常量池中, 分为  接口符号引用  以及  非接口符号引用
 *
 * 在执行字节码之前, java虚拟机需要解析这些符号引用,并替换为实际引用.
 * 对于可以静态绑定的方法调用而言,实际引用是一个指向方法的指针.
 * 对于动态绑定的方法调用而言, 实际引用则是一个方法表的索引.
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
