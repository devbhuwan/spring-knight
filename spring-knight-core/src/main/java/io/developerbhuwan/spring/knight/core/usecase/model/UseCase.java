package io.developerbhuwan.spring.knight.core.usecase.model;

@FunctionalInterface
public interface UseCase<T extends UseCaseDomain> {

    void execute(T domain);
}
