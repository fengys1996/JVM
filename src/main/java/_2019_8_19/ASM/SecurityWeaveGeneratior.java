package _2019_8_19.ASM;

import _2019_8_19.ASM.Adapter.AddSecurityCheckClassAdapter;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

public class SecurityWeaveGeneratior
{
    public static void main(String[] args) throws Exception {
        String className = Account.class.getName();
        ClassReader classReader = new ClassReader(className);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        AddSecurityCheckClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File(Account.class.getResource("").getPath() + "Account.class");
        if (file.exists()){
            System.out.println("exists");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data);
        fileOutputStream.close();
    }
}
