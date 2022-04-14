package me.realimpact.example.web;

import lombok.extern.slf4j.Slf4j;
import me.realimpact.example.dto.CreateBarRequestDto;
import me.realimpact.example.dto.CreateFooRequestDto;
import me.realimpact.example.dto.CreateLynRequestDto;
import me.realimpact.example.dto.CreateRydRequestDto;
import me.realimpact.example.service.SCSTExamplePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Slf4j
@RequestMapping("/scst")
public class SCSTExampleController {
  private SCSTExamplePublisherService scstExampleService;
  
  @Autowired
  public SCSTExampleController(SCSTExamplePublisherService scstExampleService) {
    this.scstExampleService = scstExampleService;
  }
  
  @PostMapping("/foo")
  public ResponseEntity<Mono<Void>> createFoo(@RequestBody CreateFooRequestDto dto) {
    log.info("[web] foo! {}", dto);
    return ResponseEntity
      .status(CREATED)
      .body(
        scstExampleService.createFoo(dto)
      );
  }
  
  @PostMapping("/bar")
  public ResponseEntity<Mono<Void>> createBar(@RequestBody CreateBarRequestDto dto) {
    log.info("[web] bar {}", dto);
    return ResponseEntity
      .status(CREATED)
      .body(
        scstExampleService.createBar(dto)
      );
  }
  
  @PostMapping("/lyn")
  public ResponseEntity<Mono<Void>> createLyn(@RequestBody CreateLynRequestDto dto) {
    log.info("[web] lyn! {}", dto);
    return ResponseEntity
      .status(CREATED)
      .body(
        scstExampleService.createLyn(dto)
      );
  }
  
  @PostMapping("/ryd")
  public ResponseEntity<Mono<Void>> createRyd(@RequestBody CreateRydRequestDto dto) {
    log.info("[web] ryd {}", dto);
    return ResponseEntity
      .status(CREATED)
      .body(
        scstExampleService.createRyd(dto)
      );
  }
}
