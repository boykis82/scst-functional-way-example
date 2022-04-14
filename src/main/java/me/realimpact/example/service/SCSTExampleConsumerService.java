package me.realimpact.example.service;

import me.realimpact.example.event.BarCreated;
import me.realimpact.example.event.FooCreated;
import me.realimpact.example.event.LynCreated;
import me.realimpact.example.event.RydCreated;
import reactor.core.publisher.Mono;

public interface SCSTExampleConsumerService {
  Mono<Void> applyFooCreated(FooCreated fooCreated);
  Mono<Void> applyBarCreated(BarCreated barCreated);
  Mono<Void> applyLynCreated(LynCreated lynCreated);
  Mono<Void> applyRydCreated(RydCreated rydCreated);
}
