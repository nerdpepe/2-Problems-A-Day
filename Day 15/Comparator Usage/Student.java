import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
public class Student {

    int rollNo;
    String name;

    Student(int r, String n) {
        this.name = n;
        this.rollNo = r;
    }

    @Override
    public String toString() {
        return "Student Name " + this.name + " - " + this.rollNo;
    }


static class sortStudents implements Comparator<Student> {
    @Override
    //lhs - a
    //rhs - b
    public int compare(Student a, Student b) {
        //System.out.println(a.rollNo + " - " + b.rollNo);
        if(a.rollNo < b.rollNo ) // if lhs should be before rhs then -1
            return -1;
        else if(a.rollNo > b.rollNo) // otherwise 1
            return 1;
        else return 0; // in case they are equal
    }
}


    public static void main(String ...ar) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(6,"a"));
        students.add(new Student(5,"b"));
        students.add(new Student(1,"c"));
        Collections.sort(students, new sortStudents());
        Iterator<Student> it = students.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}