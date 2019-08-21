package _2019_8_20.VisitMode.Demo_Two;

public class Speaker implements Visitor
{
    @Override
    public void visit(Animal animal)
    {
        animal.accept(this);
    }

    @Override
    public void visit(Cat cat)
    {
        System.out.println("miao~~~");
    }

    @Override
    public void visit(Dog dog)
    {
        System.out.println("wang~~~");
    }

    @Override
    public void visit(Fox fox)
    {
        System.out.println("woo~~~");
    }
}
