package _2019_8_20.Asm;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 * ASM中几个重要的类
 * 1. ClassReader:它将字节数组或者 class 文件读入到内存当中，并以树的数据结构表示，树中的一个节点代表着 class 文件中的某个区域。可以将 ClassReader 看作是 Visitor 模式中的访问者的实现类
 * 2. ClassVisitor:ClassReader 对象创建之后，调用 ClassReader#accept() 方法，传入一个 ClassVisitor 对象。在 ClassReader 中遍历树结构的不同节点时会调用 ClassVisitor 对象中不同的 visit()
 * 方法，从而实现对字节码的修改。在 ClassVisitor 中的一些访问会产生子过程，比如 visitMethod 会产生 MethodVisitor 的调用，visitField 会产生对 FieldVisitor 的调用，用户也可以对这些 Visitor
 * 进行自己的实现，从而达到对这些子节点的字节码的访问和修改。
 * 在 ASM 的访问者模式中，用户还可以提供多种不同操作的 ClassVisitor 的实现，并以责任链的模式提供给 ClassReader 来使用，而 ClassReader 只需要 accept 责任链中的头节点处的 ClassVisitor。
 * 3. ClassWrite:ClassWriter 是 ClassVisitor 的实现类,他是生成字节码的工具类,他一般是责任链中的最后一个节点,与之前的每一个ClassVisit都是致力于对原始字节码的修改,而 ClassWriter 的操作则是老实得把每一个节
 * 点修改后的字节码输出为字节数组。
 *
 * ASM的工作流程
 * 1. ClassReader 读取字节码到内存中，生成用于表示该字节码的内部表示的树，ClassReader 对应于访问者模式中的元素
 * 2. 组装 ClassVisitor 责任链，这一系列 ClassVisitor 完成了对字节码一系列不同的字节码修改工作，对应于访问者模式中的访问者 Visitor
 * 3. 然后调用 ClassReader#accept() 方法，传入 ClassVisitor 对象，此 ClassVisitor 是责任链的头结点，经过责任链中每一个 ClassVisitor 的对已加载进内存的字节码的树结构上的每个节点的访问和修改
 * 4. 最后，在责任链的末端，调用 ClassWriter 这个 visitor 进行修改后的字节码的输出工作
 */
public class Client
{
    public static void main(String[] args) throws IOException
    {
        String className = TestAsm.class.getName();
        //System.out.println(className);
        ClassReader classReader = new ClassReader(className);

    }
}
