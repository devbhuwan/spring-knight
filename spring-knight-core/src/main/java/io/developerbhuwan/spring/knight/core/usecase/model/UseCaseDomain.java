package io.developerbhuwan.spring.knight.core.usecase.model;

import io.developerbhuwan.spring.knight.core.usecase.ResultMap;

public interface UseCaseDomain {

    ResultMap<UseCaseResult> create();
}
