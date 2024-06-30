package za.ac.tut.bl;

import java.util.ArrayList;
import za.ac.tut.commonoperations.CommonOperations;
import za.ac.tut.entities.Student;
public class StudentManager {
	private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public boolean add(Student student) {
        return students.add(student);
    }

    public Student get(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            return students.get(index);
        }
        return null;
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    public boolean delete(Student student) {
        return students.remove(student);
    }

    public boolean update(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            students.set(index, student);
            return true;
        }
        return false;
    }

}
