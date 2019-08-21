package _2019_8_20.VisitMode.Demo_One;

public class PaperCountSelection implements Visitor
{

    @Override
    public void visit(Student student)
    {
        if (student != null && student.getGrade() >= 90) {
            System.out.println(student.getName() + "的PaperCount是" + student.getPaperCount());
        }
    }

    @Override
    public void visit(Teacher teacher)
    {
        if (teacher != null && teacher.getScore() >= 90) {
            System.out.println(teacher.getName() + "的PaperCount是" + teacher.getPaperCount());
        }
    }
}
