package io.developerbhuwan.spring.knight.core.usecase.lang;

import io.developerbhuwan.spring.knight.core.usecase.ResultMap;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseDomain;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseResult;
import lombok.extern.slf4j.Slf4j;

import static io.developerbhuwan.spring.knight.core.usecase.ResultMap.EMPTY;

@Slf4j
public class UseCaseScenario<T extends UseCaseDomain> implements TerminatingSpec {

    private ResultMap<UseCaseResult> _results = EMPTY;
    private T _domain;

    private UseCaseScenario(T domain) {
        _domain = domain;
    }

    public static <T extends UseCaseDomain, U> UseCaseScenario<T> select(T domain) {
        return new UseCaseScenario<>(domain);
    }


    public UseCaseResultSpec byStates() {
        return new UseCaseResultSpec(_domain.create());
    }


    @Override
    public void finish() {
    }

    private UseCaseScenario<T> _this() {
        return this;
    }


}
