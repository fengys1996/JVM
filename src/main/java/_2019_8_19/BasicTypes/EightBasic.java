package _2019_8_19.BasicTypes;

import static java.lang.Float.*;

public class EightBasic
{
    public static void main(String[] args)
    {
        /**
         * byte的取值范围是【-128,127】
         */
        //byte b;
        //b = (byte) 128;
        //System.out.println(b);
        //
        //b = (byte) 129;
        //System.out.println(b);
        //byte a = -1;
        //System.out.println(a);
        //a = (byte) 255;
        //System.out.println(a);

        //short s = (short) 32768;
        //System.out.println(s);
        float positiveInfinity = POSITIVE_INFINITY;
        float negativeInfinity = NEGATIVE_INFINITY;

        //System.out.println(isNaN(1f / 0.0f));
        float a = NaN;
        System.out.println(a == a);

        //float b = 1/0;
        //System.out.println(b);
    }
}
