package _2019_8_20.VisitMode;


public class Teacher implements Element
{
    private String name;
    private int score;
    private int paperCount;

    public Teacher(String name, int score, int paperCount) {
        this.name = name;
        this.score = score;
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

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
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
