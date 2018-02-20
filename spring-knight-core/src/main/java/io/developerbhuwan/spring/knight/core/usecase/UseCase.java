package io.developerbhuwan.spring.knight.core.usecase;

public interface UseCase<R> {

    void execute(R request);
}
