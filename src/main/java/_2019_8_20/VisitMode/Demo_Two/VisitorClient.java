package _2019_8_20.VisitMode.Demo_Two;

public class VisitorClient
{
    public static void main(String[] args)
    {
        Animal[] animals = {new Cat(), new Fox(), new Dog()};
        Speaker s = new Speaker();
        //Counter c = new Counter();
        for(Animal animal: animals)
        {
            //c.visit(animal);
        }
        //  c.log();

        for(Animal animal :animals)
        {
            s.visit(animal);
        }
    }
}
