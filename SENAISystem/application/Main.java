package SENAISystem.application;

import SENAISystem.model.entities.Course;
import SENAISystem.model.entities.Registration;
import SENAISystem.model.entities.Student;
import SENAISystem.model.entities.Teacher;
import SENAISystem.model.entities.enums.CourseName;
import SENAISystem.model.exceptions.DomainException;

public class Main {
    public static void main(String[] args) {

        try {
            // Criando dois professores

            Teacher teacher1 = new Teacher("Vinicius", 27);
            Teacher teacher2 = new Teacher("Raiam Santos", 39);
            Teacher teacher3 = new Teacher("Alfredo", 32);

            // Criando um curso

            Course course1 = new Course(CourseName.TI, teacher1);
            Course course2 = new Course(CourseName.MECÂNICA, teacher2);
            Course course3 = new Course(CourseName.MARCENARIA, teacher3);

            // Criando alunos

            Student student1 = new Student("Goku", 21);
            Student student2 = new Student("Vegeta", 23);
            Student student3 = new Student("Ben 10", 16);
            Student student4 = new Student("Scooby Doo", 12);

            // Matriculando alunos

            Registration reg1 = new Registration(student1, course1);
            Registration reg2 = new Registration(student2, course2);
            Registration reg3 = new Registration(student3, course3);
            Registration reg4 = new Registration(student4, course3);

            // Matriculando alunos em cursos

            student3.enroll(course3);
            student1.enroll(course1);
            student4.enroll(course3);

            // Concluindo matricula de algum

            reg3.conclude();

            // Cancelando matrícula de algum aluno

            reg1.cancel();

            // Listando alunos de um curso

            System.out.println(course3.listStudents());

        } catch (DomainException error) {
            System.out.println(error.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado");
        }
    }
}
