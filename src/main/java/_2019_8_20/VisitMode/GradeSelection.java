package _2019_8_20.VisitMode;

public class GradeSelection implements Visitor
{
    public void visit(Student student)
    {
        if (student != null && student.getGrade() >= 90) {
            System.out.println(student.getName() + "的分数是" + student.getGrade() + "，荣获了成绩优秀奖。");
        }
    }

    public void visit(Teacher teacher)
    {
        if (teacher != null && teacher.getScore() >= 85) {
            System.out.println(teacher.getName() + "的分数是" + teacher.getScore() + "，荣获了成绩优秀奖。");
        }
    }
}
