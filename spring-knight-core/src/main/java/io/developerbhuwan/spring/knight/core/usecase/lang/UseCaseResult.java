package io.developerbhuwan.spring.knight.core.usecase.lang;

import io.developerbhuwan.spring.knight.core.usecase.NameValue;

public class UseCaseResult<T> implements NameValue<T> {
    private String _name;
    private T _value;

    public UseCaseResult(String name, T value) {
        _name = name;
        _value = value;
    }

    public UseCaseResult(T obj) {
        _name = obj.toString();
        _value = obj;
    }

    public UseCaseResult(NameValue<T> fact) {
        _name = fact.getName();
        _value = fact.getValue();
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        this._name = name;
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public void setValue(T value) {
        this._value = value;
    }

    @Override
    public String toString() {
        return _value.toString();
    }

}
