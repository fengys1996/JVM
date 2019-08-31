package _2019_8_27.Option;
import	java.util.function.Consumer;

import java.util.Optional;

public class main
{
    public static void main(String[] args)
    {
        Optional<String> op = Optional.ofNullable("123");
        op.ifPresent(u -> {
            System.out.println(u);
        });
        op.ifPresent(new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        });
        op.ifPresent(new ConsumerImpl());
    }

    /**
     * 这里我以为用到了visit mode,但是仔细一看并不是,记录一下
     */
    static class ConsumerImpl implements Consumer<String>
    {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }
}
