package _2019_8_20.VisitMode;

public class VisitorClient
{
    public static void main(String[] args)
    {
        Element element = new Student("lijiankun24", 90, 3);

        Visitor visitor = new GradeSelection();
        element.accept(visitor);
    }
}
