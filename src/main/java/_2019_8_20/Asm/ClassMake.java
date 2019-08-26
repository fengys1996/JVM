package _2019_8_20.Asm;

import java.io.File;
import java.io.IOException;

/**
 * 今晚任务:新建Test.class,用反射的方式获取一个类
 */
public class ClassMake
{
    public static void main(String[] args) throws IOException
    {
        String systemRootUrl = (new File("")).toURI().toURL().getPath();
        System.out.println(systemRootUrl);
        File file = new File(systemRootUrl + "_2019_8_20/ASM/Test1.class");
        file.createNewFile();

    }

}
