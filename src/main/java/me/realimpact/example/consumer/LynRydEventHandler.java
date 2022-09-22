package me.realimpact.example.consumer;

import lombok.extern.slf4j.Slf4j;
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
public class LynRydEventHandler {
  
  private final SCSTExampleConsumerService scstExampleConsumerService;
  
  @Autowired
  public LynRydEventHandler(SCSTExampleConsumerService scstExampleConsumerService) {
    this.scstExampleConsumerService = scstExampleConsumerService;
  }
  
  @Bean
  public Consumer<Message<LynCreated>> lynCreated() {
    return lynCreated -> {
      log.info("header type : " + lynCreated.getHeaders().get("type"));
      scstExampleConsumerService.applyLynCreated(lynCreated.getPayload()).block();
    };
  }
  
  @Bean
  public Consumer<Message<RydCreated>> rydCreated() {
    return rydCreated -> {
      log.info("header type : " + rydCreated.getHeaders().get("type"));
      scstExampleConsumerService.applyRydCreated(rydCreated.getPayload()).block();
    };
  }
}
