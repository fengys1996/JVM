package _2019_8_31;

/**
 * java虚拟机定义的重写:
 * 子类定义了与父类中非私有,非静态方法同名的方法,只要当参数类型以及返回值一致的时候,(类名,方法名,方法描述符),java虚拟机才会判定为重写
 */
public class zilei extends fulei {
    public static void print()
    {
        System.out.println("zilei");
    }

    @Override
    public void print1() {
        super.print1();
    }
}
