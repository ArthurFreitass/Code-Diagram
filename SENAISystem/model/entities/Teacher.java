package SENAISystem.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teacher extends Person {

    private List<Course> courseList = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String name, Integer age) {
        super(name, age);
    }

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo.");
        }
        if (!courseList.contains(course)) {
            courseList.add(course);
            // Se o curso já não tiver este professor, podemos setar (opcional, cuidado com loop)
            if (course.getTeacher() != this) {
                course.setTeacher(this); // Isso chama setTeacher, que pode chamar addCourse de novo? Vamos evitar loop fazendo setTeacher não chamar addCourse.
            }
        }
    }

    public void removeCourse(Course course) {
        courseList.remove(course);
        // Se o curso tiver este professor, remover a referência? Opcional.
        if (course != null && course.getTeacher() == this) {
            course.setTeacher(null);
        }
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courseList);
    }
}
