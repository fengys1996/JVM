package _2019_8_19.ASM.Adapter;

import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class AddSecurityCheckMethodAdapter extends MethodVisitor
{
    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    @Override
    public void visitCode() {
        Label continueLabel = new Label();
        visitMethodInsn(Opcodes.INVOKESTATIC, "_2019_8_19/SecurityChecker", "checkSecurity", "()Z");
        visitJumpInsn(Opcodes.IFNE, continueLabel);
        visitInsn(Opcodes.RETURN);
        visitLabel(continueLabel);
        super.visitCode();
    }
}
