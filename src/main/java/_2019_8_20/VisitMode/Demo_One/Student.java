package _2019_8_20.VisitMode.Demo_One;

public class Student implements Element
{
    private String name;
    private int grade;
    private int paperCount;

    public Student(String name, int grade, int paperCount) {
        this.name = name;
        this.grade = grade;
        this.paperCount = paperCount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public int getPaperCount()
    {
        return paperCount;
    }

    public void setPaperCount(int paperCount)
    {
        this.paperCount = paperCount;
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
