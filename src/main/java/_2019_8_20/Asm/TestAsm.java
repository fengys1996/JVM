package _2019_8_20.Asm;

import java.io.File;
import java.net.MalformedURLException;

public class TestAsm
{
    public static void main(String[] args) throws MalformedURLException
    {
        String systemRootUrl = (new File("")).toURI().toURL().getPath();
        System.out.println(systemRootUrl);
    }
}
