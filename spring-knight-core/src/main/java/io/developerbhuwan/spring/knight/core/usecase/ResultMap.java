package io.developerbhuwan.spring.knight.core.usecase;

import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseResult;

import java.util.*;

public class ResultMap<T> implements NameValueMap<T> {

    public static ResultMap<UseCaseResult> EMPTY = new ResultMap<>();

    private Map<String, NameValue<T>> _results;

    public ResultMap(Map<String, NameValue<T>> results) {
        _results = results;
    }

    @SafeVarargs
    public ResultMap(NameValue<T>... results) {
        this();

        for (NameValue<T> fact : results) {
            this.put(fact);
        }
    }

    public ResultMap() {
        _results = new HashMap<>();
    }

    @Override
    public T getOne() {
        if (_results.size() == 1) {
            return _results.values().iterator().next().getValue();
        }
        return null;
    }

    @Override
    public T getValue(String name) {
        return Optional.ofNullable(_results.get(name)).map(NameValue::getValue).orElse(null);
    }

    public void setValue(String name, T value) {
        NameValue<T> fact = _results.get(name);
        if (fact == null) {
            fact = new io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult(name, value);
            _results.put(name, fact);
            return;
        }
        fact.setValue(value);
    }

    @Override
    public io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult put(NameValue<T> fact) {
        return put(fact.getName(), fact);
    }

    @Override
    public io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult put(String key, NameValue<T> fact) {
        Optional<NameValue<T>> prev = Optional.ofNullable(_results.put(key, fact));
        return prev.map(obj -> obj instanceof io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult ? (io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult) obj : new io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult(obj)).orElse(null);
    }

    @Override
    public int size() {
        return _results.size();
    }

    @Override
    public boolean isEmpty() {
        return _results.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return _results.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return _results.containsValue(value);
    }

    @Override
    public io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult get(Object key) {
        NameValue<T> obj = _results.get(key);
        if (obj == null) {
            return null;
        }
        if (obj instanceof io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult) {
            return (io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult) obj;
        }
        return new io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult(obj);
    }

    @Override
    public io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult remove(Object key) {
        NameValue<T> obj = _results.remove(key);
        if (obj == null) {
            return null;
        }
        if (obj instanceof io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult) {
            return (io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult) obj;
        }
        return new io.developerbhuwan.spring.knight.core.usecase.lang.UseCaseResult(obj);
    }

    @Override
    public void putAll(Map<? extends String, ? extends NameValue<T>> map) {
        _results.putAll(map);
    }

    @Override
    public void clear() {
        _results.clear();
    }

    @Override
    public Set<String> keySet() {
        return _results.keySet();
    }

    @Override
    public Collection<NameValue<T>> values() {
        return _results.values();
    }

    @Override
    public Set<Entry<String, NameValue<T>>> entrySet() {
        return _results.entrySet();
    }

    @Override
    public String toString() {
        return _results.size() == 1 ? this.getOne().toString() : _results.toString();
    }
}

