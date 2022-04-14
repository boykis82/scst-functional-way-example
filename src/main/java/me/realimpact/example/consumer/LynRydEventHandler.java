package me.realimpact.example.consumer;

import lombok.extern.slf4j.Slf4j;
import me.realimpact.example.event.LynCreated;
import me.realimpact.example.event.RydCreated;
import me.realimpact.example.service.SCSTExampleConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
  public Consumer<LynCreated> lynCreated() {
    return lynCreated -> {
      scstExampleConsumerService.applyLynCreated(lynCreated).block();
    };
  }
  
  @Bean
  public Consumer<RydCreated> rydCreated() {
    return rydCreated -> {
      scstExampleConsumerService.applyRydCreated(rydCreated).block();
    };
  }
}
