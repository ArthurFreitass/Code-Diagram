package SENAISystem.model.entities;

import SENAISystem.model.entities.enums.CourseName;
import SENAISystem.model.entities.enums.RegistrationStatus;
import SENAISystem.model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {

    private CourseName courseName;
    private Teacher teacher;
    private List<Registration> registrationList = new ArrayList<>();

    public Course() {
    }

    public Course(CourseName courseName, Teacher teacher) {
        if (courseName == null) {
            throw new DomainException("Erro: O nome do curso está inválido!");
        }
        if (teacher == null) {
            throw new DomainException("Erro: o professor não pode ser nulo!");
        }
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public CourseName getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // Método para adicionar uma matrícula
    public void addRegistration(Registration registration) {
        if (registration == null) {
            throw new DomainException("Erro: Matrícula não pode ser nula.");
        }
        if (!registrationList.contains(registration)) {
            registrationList.add(registration);
        }
    }

    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrationList);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Registration reg : registrationList) {
            students.add(reg.getStudent());
        }
        return Collections.unmodifiableList(students);
    }

    public List<Student> getActiveStudents() {
        List<Student> activeStudents = new ArrayList<>();
        for (Registration reg : registrationList) {
            if (reg.getRegistrationStatus() == RegistrationStatus.ATIVA) {
                activeStudents.add(reg.getStudent());
            }
        }
        return Collections.unmodifiableList(activeStudents);
    }

    public String listStudents() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(courseName).append("\n");
        sb.append("Professor: ").append(teacher != null ? teacher.getName() : "Não definido").append("\n");
        sb.append("Alunos matriculados:\n");
        for (Registration reg : registrationList) {
            sb.append("- ").append(reg.getStudent().getName())
                    .append(" (Status: ").append(reg.getRegistrationStatus())
                    .append(", Data: ").append(reg.getRegistrationDate()).append(")\n");
        }
        return sb.toString();
    }
}
