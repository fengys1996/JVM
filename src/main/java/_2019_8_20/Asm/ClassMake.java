package _2019_8_20.Asm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * 今晚任务:新建Test.class,用反射的方式获取一个类
 * 2019-8-27任务:理解原理以及写一个自定义的classloader
 */
public class ClassMake
{
    public static void main(String[] args) throws IOException
    {
        String systemRootUrl = (new File("")).toURI().toURL().getPath();
        File file=new File(systemRootUrl+"_2019_8_20/Asm/Test.class");
        String parent=file.getParent();
        File parent1=new File(parent);
        parent1.mkdirs();
        file.createNewFile();

        /**
         * public interface IA{}
         */
        /*ClassWriter cw1 = new ClassWriter(0);
        cw1.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "asm/IA", null,
                "java/lang/Object", null);
        cw1.visitSource("IA.java", null);
        cw1.visitEnd();*/

        /**
         * public abstract class A{}
         */
        /*ClassWriter cw2 = new ClassWriter(0);
        cw2.visit(V1_5, ACC_PUBLIC + ACC_SUPER + ACC_ABSTRACT, "asm/A", null, "java/lang/Object", null);
        cw2.visitSource("A.java", null);
        cw2.visitEnd();*/

        /**
         * public class A{}
         */
        ClassWriter cw3 = new ClassWriter(0);
        cw3.visit(V1_5, ACC_PUBLIC + ACC_SUPER, "asm/A", null, "java/lang/Object", null);
        cw3.visitSource("A.java", null);


        MethodVisitor initVisitor = cw3.visitMethod(ACC_PUBLIC, "<init>",
                "()V", null, null);
        initVisitor.visitCode();
        initVisitor.visitVarInsn(ALOAD, 0);
        initVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>",
                "V()");
        initVisitor.visitInsn(RETURN);
        initVisitor.visitMaxs(1, 1);
        initVisitor.visitEnd();


        MethodVisitor helloVisitor = cw3.visitMethod(ACC_PUBLIC, "sayHello",
                "()V;", null, null);
        helloVisitor.visitCode();
        helloVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        helloVisitor.visitLdcInsn("hello world!");
        helloVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
                "println", "(Ljava/lang/String;)V");
        helloVisitor.visitInsn(RETURN);
        helloVisitor.visitMaxs(1, 1);
        helloVisitor.visitEnd();


        cw3.visitEnd();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(cw3.toByteArray());



    }

}
