package _2019_8_31;

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


    /**
     * 重载的选取方法:
     * 1.
     * @param args
     */
    public static void main(String[] args) {
        /*invoke(null, 1);
        invoke(null,1, 2);*/
        invoke(null, new Object[]{1});

        System.out.println("~~~~~~~~~~~~~~");

        invoke(1);
        invoke(new Integer(1));
    }
}
