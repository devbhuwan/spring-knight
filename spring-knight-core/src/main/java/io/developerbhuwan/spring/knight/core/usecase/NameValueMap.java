package io.developerbhuwan.spring.knight.core.usecase;

import java.util.Map;

public interface NameValueMap<T> extends Map<String, NameValue<T>> {
    T getOne();

    T getValue(String name);

    void setValue(String name, T obj);

    NameValue<T> put(NameValue<T> ref);
}
