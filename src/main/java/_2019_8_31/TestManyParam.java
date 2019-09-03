package _2019_8_31;

/**
 * 重载方法的优先级：
 * 1.在不考虑对基本类型自动装拆箱，以及可变长参数的情况下选取重载方法；
 * 2.如果在第 1 个阶段中没有找到适配的方法，那么在允许自动装拆箱，但不允许可变长参数的情况下选取重载方法；
 * 3.如果在第 2 个阶段中没有找到适配的方法，那么在允许自动装拆箱以及可变长参数的情况下选取重载方法。
 *
 * 如果java在同一阶段找到了多个适配的方法：他会选择一个最为贴切的。
 * 1.决定贴切的关键是：形式参数类型的继承关系
 */
public class TestManyParam {

    public static void invoke(Object object, Object ...objects) {
        System.out.println("执行方法1");
    }

    public static void invoke(String s, Object object, Object ...objects) {
        System.out.println("执行方法2");
    }

    /**
     * 验证拆装箱
     */
    public static void invoke(Integer i) {
        System.out.println("执行方法1");
    }

    public static void invoke(int i) {
        System.out.println("执行方法2");
    }

    public static void invoke(int...i){
        System.out.println("执行方法3");
    }

    public static void invoke(Integer...i){
        System.out.println("执行方法4");
    }

    public static void invoke1(Object object)
    {
        System.out.println("执行方法1");
    }

    public static void invoke1(String strObject)
    {
        System.out.println("执行方法2");
    }


    public static void main(String[] args) {
        /*invoke(null, 1);
        invoke(null,1, 2);*/
        invoke(null, new Object[]{1});

        System.out.println("~~~~~~~~~~~~~~");

        invoke(1);
        invoke(new Integer(1));

        System.out.println("~~~~~~~~~~~~~~");

        invoke1(null);
        invoke1(null);
    }
}
