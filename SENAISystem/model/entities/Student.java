package SENAISystem.model.entities;

import SENAISystem.model.entities.enums.RegistrationStatus;
import SENAISystem.model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {

    private List<Registration> registrationList = new ArrayList<>();

    public Student() {
    }

    public Student(String name, Integer age) {
        super(name, age);
    }

    // Método para matricular o aluno em um curso
    public Registration enroll(Course course) {
        // Verifica se já existe matrícula ativa para este curso
        for (Registration reg : registrationList) {
            if (reg.getCourse().equals(course) && reg.getRegistrationStatus() == RegistrationStatus.ATIVA) {
                throw new DomainException("Erro: O aluno já possui matrícula ativa neste curso.");
            }
        }
        // Cria a nova matrícula
        Registration newReg = new Registration(this, course);
        registrationList.add(newReg);
        // Adiciona a matrícula também na lista do curso
        course.addRegistration(newReg);
        return newReg;
    }

    // Cancela uma matrícula específica (desde que pertença a este aluno)
    public void cancelRegistration(Registration reg) {
        if (!registrationList.contains(reg)) {
            throw new DomainException("Erro: Esta matrícula não pertence a este aluno.");
        }
        reg.cancel();
    }

    // Retorna uma cópia da lista de matrículas (imutável)
    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrationList);
    }

    // Retorna apenas as matrículas ativas
    public List<Registration> getActiveRegistrations() {
        List<Registration> active = new ArrayList<>();
        for (Registration reg : registrationList) {
            if (reg.getRegistrationStatus() == RegistrationStatus.ATIVA) {
                active.add(reg);
            }
        }
        return Collections.unmodifiableList(active);
    }
}
