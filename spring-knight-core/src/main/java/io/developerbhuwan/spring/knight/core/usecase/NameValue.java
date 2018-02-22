package io.developerbhuwan.spring.knight.core.usecase;

public interface NameValue<T> {

    String getName();

    void setName(String name);

    T getValue();

    void setValue(T obj);
}
