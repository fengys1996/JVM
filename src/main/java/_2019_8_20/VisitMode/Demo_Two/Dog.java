package _2019_8_20.VisitMode.Demo_Two;

public class Dog implements Animal
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
