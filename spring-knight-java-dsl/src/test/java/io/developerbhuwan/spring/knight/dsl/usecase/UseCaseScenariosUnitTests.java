package io.developerbhuwan.spring.knight.dsl.usecase;

import io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseScenario;
import io.developerbhuwan.spring.knight.core.usecase.model.DomainEvent;
import io.developerbhuwan.spring.knight.core.usecase.model.Publisher;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseDomain;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCase;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.junit.Test;

public class UseCaseScenariosUnitTests {



    @Test
    public void publishEventAfterPersonEntryIsSuccessful() {
        Publisher<DomainEvent<Person>> acceptedPublisher = source -> null;
        UseCaseScenario
                .select(new AddPersonUseCase())
                .execute(new PersonEntry("Bhuwan Upadhyay"));


    }

    private String acceptedPublish() {
        return null;
    }


    private interface PersonRepository {
        Person save(PersonEntry personEntry);
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    @ToString
    private class PersonEntry implements UseCaseDomain {
        private final String fullName;
    }

    private class AddPersonUseCase implements UseCase<PersonEntry> {

        @Override
        public void execute(UseCaseDomain request) {
        }
    }

    private class Person {
    }

}