package io.developerbhuwan.spring.knight.core.usecase.lang;

import io.developerbhuwan.spring.knight.core.usecase.ResultMap;
import io.developerbhuwan.spring.knight.core.usecase.model.UseCaseResult;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Function;

import static io.developerbhuwan.spring.knight.core.usecase.ResultMap.EMPTY;

@Slf4j
public final class UseCaseResultSpec implements TerminatingSpec {

    private final ResultMap<UseCaseResult> _results;

    UseCaseResultSpec(ResultMap<UseCaseResult> results) {
        _results = Optional.ofNullable(results).orElse(EMPTY);
    }

    public UseCaseResultSpec publishEvent(Function<ResultMap<UseCaseResult>, PublishSpec> eventFunction) {
        PublishSpec publishSpec = eventFunction.apply(_results);
        publishSpec.events().forEach(domainEvent -> {
            LOG.info("Published event [{}]", domainEvent.getClass().getName());
            publishSpec.publisher().publish(domainEvent);
        });
        return _this();
    }


    public <T> UseCaseResultSpec publishEventIf(Function<ResultMap<UseCaseResult>, Boolean> condition,
                                                Function<ResultMap<UseCaseResult>, PublishSpec> eventFunction) {
        if (condition.apply(_results))
            publishEvent(eventFunction);
        return _this();
    }

    public <R> UseCaseResultSpec justDo(Function<ResultMap<UseCaseResult>, R> actionFunction) {
        actionFunction.apply(_results);
        return _this();
    }

    public <R> UseCaseResultSpec doIf(Function<ResultMap<UseCaseResult>, Boolean> condition,
                                      Function<ResultMap<UseCaseResult>, R> actionFunction) {
        if (condition.apply(_results))
            justDo(actionFunction);
        return _this();
    }

    private UseCaseResultSpec _this() {
        return this;
    }

    public void finish() {
        LOG.info("Finished use-case scenario.");
    }

}
