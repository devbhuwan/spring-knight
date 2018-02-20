package io.developerbhuwan.spring.knight.core.usecase;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.junit.Before;
import org.junit.Test;

public class UseCaseUnitTests {

    private final PersonEntry PERSON_ENTRY = new PersonEntry("Bhuwan Upadhyay");
    AddPersonUseCase addPersonUseCase;

    @Before
    public void setUp() {
        addPersonUseCase = new AddPersonUseCase();
    }

    @Test(expected = UseCaseExecutedException.class)
    public void shouldExecuteUseCase() {
        addPersonUseCase.execute(PERSON_ENTRY);
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    @ToString
    private class PersonEntry implements Request {
        private final String fullName;
    }

    private class AddPersonUseCase implements UseCase<PersonEntry> {

        @Override
        public void execute(PersonEntry request) {
            throw new UseCaseExecutedException();
        }
    }

    private class UseCaseExecutedException extends RuntimeException {
    }
}