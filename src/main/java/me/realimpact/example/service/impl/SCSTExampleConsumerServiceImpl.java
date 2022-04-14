package me.realimpact.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.realimpact.example.event.BarCreated;
import me.realimpact.example.event.FooCreated;
import me.realimpact.example.event.LynCreated;
import me.realimpact.example.event.RydCreated;
import me.realimpact.example.service.SCSTExampleConsumerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class SCSTExampleConsumerServiceImpl implements SCSTExampleConsumerService {
  @Override
  public Mono<Void> applyFooCreated(FooCreated fooCreated) {
    return Mono.fromRunnable(() ->
      log.info("fooCreated! uuid = {}, title2 = {}, comment2 = {}", fooCreated.getUuid(), fooCreated.getTitle2(), fooCreated.getComment2())
    ).then();
  }
  
  @Override
  public Mono<Void> applyBarCreated(BarCreated barCreated) {
    return Mono.fromRunnable(() ->
      log.info("barCreated! uuid = {}, title = {}, comment = {}", barCreated.getUuid(), barCreated.getTitle(), barCreated.getComment())
    ).then();
  }
  
  @Override
  public Mono<Void> applyLynCreated(LynCreated lynCreated) {
    return Mono.fromRunnable(() ->
      log.info("lynCreated! uuid = {}, name = {}, job = {}", lynCreated.getUuid(), lynCreated.getName(), lynCreated.getJob())
    ).then();
  }
  
  @Override
  public Mono<Void> applyRydCreated(RydCreated rydCreated) {
    return Mono.fromRunnable(() ->
      log.info("rydCreated! uuid = {}, name2 = {}, job2 = {}", rydCreated.getUuid(), rydCreated.getName2(), rydCreated.getJob2())
    ).then();
  }
}
