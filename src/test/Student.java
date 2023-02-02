package test;

/**
 * @projectName: leetcode
 * @package: test
 * @className: Student
 * @author: WenHui
 * @description: TODO
 * @date: 2023/1/16 10:02
 * @version: 1.0
 */
public class Student extends People {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
