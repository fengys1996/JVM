package _2019_8_31.InvokeTest;

public class TestImpl implements Test {
    @Override
    public boolean isVip() {
        return false;
    }

    public void Call()
    {
        Test test = new TestImpl();
        test.isVip();

        beCalled();
        beCalled1();

    }

    public void beCalled()
    {

    }

    private void beCalled1()
    {

    }
}
