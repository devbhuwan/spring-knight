package io.developerbhuwan.spring.knight.core.usecase.model;

public interface DomainEvent<T> {

    T payload();

}
