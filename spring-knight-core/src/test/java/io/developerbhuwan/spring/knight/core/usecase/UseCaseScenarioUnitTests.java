package io.developerbhuwan.spring.knight.core.usecase;

import io.developerbhuwan.spring.knight.core.usecase.fakes.FakePublisher;
import io.developerbhuwan.spring.knight.core.usecase.fakes.FakePublisherIsCalledException;
import io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseScenario;
import io.developerbhuwan.spring.knight.core.usecase.model.DomainEvent;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCase;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseDomain;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseResult;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static io.developerbhuwan.spring.knight.core.usecase.lang.PublishSpec.by;
import static java.util.function.Function.identity;

public class UseCaseScenarioUnitTests {

    private final FakePublisher fakePublisher = new FakePublisher();
    private AddPersonUseCase addPersonUseCase;

    @Before
    public void setUp() {
        addPersonUseCase = new AddPersonUseCase();
    }

    @Test(expected = FakePublisherIsCalledException.class)
    public void publishEventAfterPersonEntryIsSuccessful() {
        PersonEntry personEntry = new PersonEntry("Bhuwan Upadhyay");
        addPersonUseCase.execute(personEntry);
    }


    private interface PersonRepository {
        Person save(PersonEntry personEntry);
    }

    private class PersonEntryFinishedEvent implements DomainEvent<Person> {

        public PersonEntryFinishedEvent(ResultMap<UseCaseResult> result) {

        }

        @Override
        public Person payload() {
            return null;
        }

    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    @ToString
    private class PersonEntry implements UseCaseDomain {
        private final String fullName;

        @Override
        public ResultMap<UseCaseResult> create() {
            return null;
        }
    }

    private class AddPersonUseCase implements UseCase<PersonEntry> {

        @Override
        public void execute(PersonEntry domain) {
            UseCaseScenario
                    .select(domain)
                    .byStates()
                    .doIf(Objects::nonNull, identity())
                    .justDo(identity())
                    .publishEventIf(Objects::nonNull, r -> by(fakePublisher).event(new PersonEntryFinishedEvent(r)))
                    .finish();
        }
    }

    private class Person {
    }

}