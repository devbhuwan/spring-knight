package io.developerbhuwan.spring.knight.core.usecase.fakes;

import io.developerbhuwan.spring.knight.core.usecase.model.DomainEvent;
import io.developerbhuwan.spring.knight.core.usecase.model.Publisher;

public class FakePublisher implements Publisher {

    @Override
    public <T> void publish(DomainEvent<T> event) {
        throw new FakePublisherIsCalledException();
    }

}
