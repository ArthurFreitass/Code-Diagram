package SENAISystem.model.entities;

import SENAISystem.model.exceptions.DomainException;

public abstract class Person {

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        if (name == null) {
            throw new DomainException("Erro: O nome não pode ser nulo!");
        }
        if (name.isEmpty()) {
            throw new DomainException("Erro: O nome não pode ser vazio!");
        }
        if (age == null) {
            throw new DomainException("Erro: A idade não pode ser nula!");
        }
        if (age < 0 || age > 120) {
            throw new DomainException("Erro: Idade impossível!");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
