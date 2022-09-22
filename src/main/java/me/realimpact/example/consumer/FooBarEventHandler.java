package me.realimpact.example.consumer;

import lombok.extern.slf4j.Slf4j;
import me.realimpact.example.event.BarCreated;
import me.realimpact.example.event.FooCreated;
import me.realimpact.example.event.LynCreated;
import me.realimpact.example.event.RydCreated;
import me.realimpact.example.service.SCSTExampleConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class FooBarEventHandler {
  
  private final SCSTExampleConsumerService scstExampleConsumerService;
  
  @Autowired
  public FooBarEventHandler(SCSTExampleConsumerService scstExampleConsumerService) {
    this.scstExampleConsumerService = scstExampleConsumerService;
  }
  
  @Bean
  public Consumer<Message<FooCreated>> fooCreated() {
    return fooCreated -> {
      log.info("header type : " + fooCreated.getHeaders().get("type"));
      scstExampleConsumerService.applyFooCreated(fooCreated.getPayload()).block();
    };
  }
  
  @Bean
  public Consumer<Message<BarCreated>> barCreated() {
    return barCreated -> {
      log.info("header type : " + barCreated.getHeaders().get("type"));
      scstExampleConsumerService.applyBarCreated(barCreated.getPayload()).block();
    };
  }
}
