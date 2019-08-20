package _2019_8_19.ASM.Adapter;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class AddSecurityCheckClassAdapter extends ClassVisitor
{
    public AddSecurityCheckClassAdapter(ClassVisitor classVisitor)
    {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {


        MethodVisitor mv = super.visitMethod(i, s, s1, s2, strings);

        MethodVisitor wrappedMv = mv;

        if (mv != null){
            if (s.equals("operation")){
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            }
        }
        return wrappedMv;
    }
}
