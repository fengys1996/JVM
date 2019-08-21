package _2019_8_20.VisitMode.Demo_One;

/**
 * 定义:封装某些作用于某种数据结构中各元素的操作，它可以在不改变数据结构的前提下定义作用于这些数据元素的新的操作
 * 意图:主要将数据结构和数据操作分离
 * 主要解决:稳定的数据结构和易变的操作的解耦
 * 使用场景:
 * 1. 假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，可以使用访问者模式把这些操作封装到访问者中去，这样便避免了这些不相干的操作污染这个对象。
 * 2. 假如一组对象中，存在着相似的操作，可以将这些相似的操作封装到访问者中去，这样便避免了出现大量重复的代码
 * 3. 访问者模式适用于对功能已经确定的项目进行重构的时候适用，因为功能已经确定，元素类的数据结构也基本不会变了；如果是一个新的正在开发中的项目，在访问者模式中，每一个元素类都有它对应的处理方法，每增加一个元素类都需要修改访问者类，修改起来相当麻烦。
 */
public class VisitorClient
{
    public static void main(String[] args)
    {
        Element element = new Student("lijiankun24", 90, 3);

        Visitor gradeVisitor = new GradeSelection();
        element.accept(gradeVisitor);

        Visitor heightVisitor = new PaperCountSelection();
        element.accept(heightVisitor);
    }
}
