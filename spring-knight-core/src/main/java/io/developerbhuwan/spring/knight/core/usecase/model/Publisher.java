package io.developerbhuwan.spring.knight.core.usecase.model;

public interface Publisher {

    <T> void publish(DomainEvent<T> event);
}