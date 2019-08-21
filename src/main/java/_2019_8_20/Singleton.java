package _2019_8_20;

/**
 * 类的初始化何时被触发:
 * 1. 当虚拟机启动时，初始化用户指定的主类:
 * 2. 当遇到用以新建目标类实例的 new 指令时，初始化 new 指令的目标类:
 * 3. 当遇到调用静态方法的指令时，初始化该静态方法所在的类:
 * 4. 当遇到访问静态字段的指令时，初始化该静态字段所在的类:
 * 5. 子类的初始化会触发父类的初始化:
 * 6. 使用反射 API 对某个类进行反射调用时，初始化这个类:
 * 7. 如果一个接口定义了 default 方法，那么直接实现或者间接实现该接口的类的初始化，会触发该接口的初始化:???
 * 8. 当初次调用 MethodHandle 实例时，初始化该 MethodHandle 指向的方法所在的类.???
 *
 * 思路:new 引用类型的数组
 * 1. 验证是否加载:
 *      javac Singleton.java    java -verbose:class Singleton    然后便可看到初始化引用类型的数组,会触发引用类型的加载
 * 2. 验证是否链接:
 *      因为链接的第一步是验证加载后的class字节流是否符合JVM规范,所以当修改生成的class文件,看是否会报错,如果报错,则说明进行了链接,如果没有报错,则说明*   没有进行链接
 * 总结:新建引用类型的数组，只会加载，不会链接和初始化。链接和初始化在真正实例化的时候触发
 */
public class Singleton
{
    private Singleton()
    {

    }

    /**
     * 由于类初始化是线程安全的，并且仅被执行一次，因此程序可以确保多线程环境下有且仅有一个
     * Singleton 实例。
     */
    private static class LazyHolder
    {
        static final Singleton INSTANCE = new Singleton();
        static
        {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag)
        {
            return new LazyHolder[2];
        }
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args)
    {
        getInstance(true);
        //System.out.println("---");
        //getInstance(false);
        //Singleton instance = LazyHolder.INSTANCE;
    }
}
