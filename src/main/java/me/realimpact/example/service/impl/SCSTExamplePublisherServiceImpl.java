package me.realimpact.example.service.impl;

import me.realimpact.example.dto.CreateBarRequestDto;
import me.realimpact.example.dto.CreateFooRequestDto;
import me.realimpact.example.dto.CreateLynRequestDto;
import me.realimpact.example.dto.CreateRydRequestDto;
import me.realimpact.example.event.BarCreated;
import me.realimpact.example.event.FooCreated;
import me.realimpact.example.event.LynCreated;
import me.realimpact.example.event.RydCreated;
import me.realimpact.example.service.SCSTExamplePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.UUID;

@Service
public class SCSTExamplePublisherServiceImpl implements SCSTExamplePublisherService {

  public static final String HEADER_EVENT_TYPE = "type";
  
  public static final String FOOBAR_OUT_BINDING = "foobar-out-0";
  public static final String LYNRYD_OUT_BINDING = "lynryd-out-0";
  
  private final Scheduler publishEventScheduler;
  private final StreamBridge streamBridge;
  
  @Autowired
  public SCSTExamplePublisherServiceImpl(
    @Qualifier("publishEventScheduler") Scheduler publishEventScheduler,
    StreamBridge streamBridge) {
    this.publishEventScheduler = publishEventScheduler;
    this.streamBridge = streamBridge;
  }
  
  @Override
  public Mono<Void> createFoo(CreateFooRequestDto requestDto) {
    FooCreated fooCreated = FooCreated.builder()
      .uuid(UUID.randomUUID())
      .title2(requestDto.getTitle2())
      .comment2(requestDto.getComment2())
      .build();
    Message<FooCreated> fooCreatedMessage = MessageBuilder.withPayload(fooCreated)
      .setHeader(HEADER_EVENT_TYPE, "fooCreated")
      .build();
    
    return Mono.fromRunnable(
      () -> streamBridge.send(FOOBAR_OUT_BINDING, fooCreatedMessage)
    ).subscribeOn(publishEventScheduler).then();
  }
  
  @Override
  public Mono<Void> createBar(CreateBarRequestDto requestDto) {
    BarCreated barCreated = BarCreated.builder()
      .uuid(UUID.randomUUID())
      .title(requestDto.getTitle())
      .comment(requestDto.getComment())
      .build();
    Message<BarCreated> barCreatedMessage = MessageBuilder.withPayload(barCreated)
      .setHeader(HEADER_EVENT_TYPE, "barCreated")
      .build();
  
    return Mono.fromRunnable(
      () -> streamBridge.send(FOOBAR_OUT_BINDING, barCreatedMessage)
    ).subscribeOn(publishEventScheduler).then();
  }
  
  @Override
  public Mono<Void> createLyn(CreateLynRequestDto requestDto) {
    LynCreated lynCreated = LynCreated.builder()
      .uuid(UUID.randomUUID())
      .name(requestDto.getName())
      .job(requestDto.getJob())
      .build();
    Message<LynCreated> lynCreatedMessage = MessageBuilder.withPayload(lynCreated)
      .setHeader(HEADER_EVENT_TYPE, "lynCreated")
      .build();
  
    return Mono.fromRunnable(
      () -> streamBridge.send(LYNRYD_OUT_BINDING, lynCreatedMessage)
    ).subscribeOn(publishEventScheduler).then();
  }
  
  @Override
  public Mono<Void> createRyd(CreateRydRequestDto requestDto) {
    RydCreated rydCreated = RydCreated.builder()
      .uuid(UUID.randomUUID())
      .name2(requestDto.getName2())
      .job2(requestDto.getJob2())
      .build();
    Message<RydCreated> rydCreatedMessage = MessageBuilder.withPayload(rydCreated)
      .setHeader(HEADER_EVENT_TYPE, "rydCreated")
      .build();
  
    return Mono.fromRunnable(
      () -> streamBridge.send(LYNRYD_OUT_BINDING, rydCreatedMessage)
    ).subscribeOn(publishEventScheduler).then();
  }
}
