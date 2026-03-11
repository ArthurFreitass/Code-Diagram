package SENAISystem.model.entities;

import SENAISystem.model.entities.enums.RegistrationStatus;
import SENAISystem.model.exceptions.DomainException;

import java.time.LocalDate;

public class Registration {

    private Student student;
    private Course course;
    private RegistrationStatus registrationStatus;
    private LocalDate registrationDate;

    public Registration() {
    }

    public Registration(Student student, Course course) {
        if (student == null) {
            throw new DomainException("Erro: O objeto aluno não pode ser nulo!");
        }
        if (course == null) {
            throw new DomainException("Erro: O objeto curso não pode ser nulo!");
        }
        this.student = student;
        this.course = course;
        this.registrationStatus = RegistrationStatus.ATIVA;
        this.registrationDate = LocalDate.now();
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void conclude() {
        if (registrationStatus != RegistrationStatus.ATIVA) {
            throw new DomainException("Erro: A matrícula só pode ser concluída se estiver ativa");
        }
        registrationStatus = RegistrationStatus.CONCLUÍDA;
    }

    public void cancel() {
        if (registrationStatus != RegistrationStatus.ATIVA) {
            throw new DomainException("Erro: A matrícula só pode ser cancelada se estiver ativa");
        }
        registrationStatus = RegistrationStatus.CANCELADA;
    }
}
