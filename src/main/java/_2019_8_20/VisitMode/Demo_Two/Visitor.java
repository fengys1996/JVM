package _2019_8_20.VisitMode.Demo_Two;

public interface Visitor
{
    void visit(Animal animal);

    void visit(Cat cat);

    void visit(Dog dog);

    void visit(Fox fox);
}
