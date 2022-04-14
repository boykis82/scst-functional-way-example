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
  public Consumer<FooCreated> fooCreated() {
    return fooCreated -> {
      scstExampleConsumerService.applyFooCreated(fooCreated).block();
    };
  }
  
  @Bean
  public Consumer<BarCreated> barCreated() {
    return barCreated -> {
      scstExampleConsumerService.applyBarCreated(barCreated).block();
    };
  }
}
