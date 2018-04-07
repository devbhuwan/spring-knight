package io.developerbhuwan.spring.knight.core.usecase.lang;

import io.developerbhuwan.spring.knight.core.usecase.model.DomainEvent;
import io.developerbhuwan.spring.knight.core.usecase.model.Publisher;

import java.util.LinkedHashSet;
import java.util.Set;


public final class PublishSpec {
    private final Publisher publisher;
    private final Set<DomainEvent<?>> domainEvents = new LinkedHashSet<>();

    private PublishSpec(Publisher publisher) {
        this.publisher = publisher;
    }

    public static PublishSpec by(Publisher publisher) {
        return new PublishSpec(publisher);
    }

    public <T> PublishSpec event(DomainEvent<T> event) {
        domainEvents.add(event);
        return _this();
    }

    private PublishSpec _this() {
        return this;
    }

    public Set<DomainEvent<?>> events() {
        return domainEvents;
    }

    public Publisher publisher() {
        return publisher;
    }
}
