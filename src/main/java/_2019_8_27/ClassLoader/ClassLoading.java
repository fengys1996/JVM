package _2019_8_27.ClassLoader;

/**
 * 1.预加载.虚拟机启动时加载, 加载的是JAVA_HOME/lib/下的rt.jar下的.class文件, 这个jar包里面的内容是程序运行时非常常常用到的, 像java.lang.*、java.util.*、java.io.*等等，
 *      因此随着虚拟机一起加载. 要证明这一点很简单, 写一个空的main函数, 设置虚拟机参数为"-XX:+TraceClassLoading"来获取类加载信息,运行一下.
 * 2.运行时加载。虚拟机在用到一个.class文件的时候，会先去内存中查看一下这个.class文件有没有被加载，如果没有就会按照类的全限定名来加载这个类。
 *
 * 加载阶段做了三件事:
 *      1.获取.class文件的二进制流
 *      2.将类信息,静态变量,字节码,常量这些.class文件中的内容放入方法去
 *      3.在内存中生成一个代表这个.class文件的java.lang.Class对象, 作为方法区这个类的各种数据的访问入口。一般这个Class是在堆里的，不过HotSpot虚拟机比较特殊，这个Class对象是放在方法区中的
 * · 从zip包中获取，这就是以后jar、ear、war格式的基础
 * · 从网络中获取，典型应用就是Applet
 * · 运行时计算生成，典型应用就是动态代理技术
 * · 由其他文件生成，典型应用就是JSP，即由JSP生成对应的.class文件
 * · 从数据库中读取，这种场景比较少见
 */
public class ClassLoading
{
    public static void main(String[] args)
    {
        //启动类加载器(Bootstrap ClassLoader)它负责加载的是JAVA_HOME/lib下的类库，系统类加载器无法被Java程序直接应用
        //扩展类加载器(Extension ClassLoader)
        System.out.println(System.getProperty("java.ext.dirs"));

        //应用程序类加载器(Application ClassLoader)
        System.out.println(ClassLoader.getSystemClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //Application ClassLoader只能加载项目bin目录下的.class文件.
        System.out.println(System.getProperty("java.class.path"));

        /**
         * 双亲委派原则(JDK1.2引入)
         *      1.如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成，每一个层次的类加载器都是如此。
         *      2.只有当父加载器反馈自己无法完成这这个加载请求（它的搜索范围中没有找到所需的类）时，子加载器才会尝试自己去加载
         * why has ?
         *      其实所有的加载请求最终都应该传送到顶层的启动类加载器中。双亲委派模型对于Java程序的稳定运作很重要，因为Java类随着它的加载器一起具备了一种带有优先级的层次关系。
         *      例如java.lang.Object，存放于rt.jar中，无论哪一个类加载器要去加载这个类，最终都是由Bootstrap ClassLoader去加载，因此Object类在程序的各种类加载器环境中都是一个类。
         *      相反，如果没有双亲委派模型，由各个类自己去加载的话，如果用户自己编写了一个java.lang.Object，并放在CLASSPATH下，那系统中将会出现多个不同的Object类，
         *      Java体系中最基础的行为也将无法保证，应用程序也将会变得一片混乱。
         */
    }
}
