package io.developerbhuwan.spring.knight.core.usecase;

import io.developerbhuwan.spring.knight.core.usecase.model.UseCase;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseDomain;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseResult;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.junit.Before;
import org.junit.Test;

public class UseCaseUnitTests {

    private final PersonEntry PERSON_ENTRY = new PersonEntry("Bhuwan Upadhyay");
    private AddPersonUseCase addPersonUseCase;

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
            throw new UseCaseExecutedException();
        }
    }

    private class UseCaseExecutedException extends RuntimeException {
    }
}