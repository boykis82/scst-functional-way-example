package me.realimpact.example.service;

import me.realimpact.example.dto.CreateBarRequestDto;
import me.realimpact.example.dto.CreateFooRequestDto;
import me.realimpact.example.dto.CreateLynRequestDto;
import me.realimpact.example.dto.CreateRydRequestDto;
import reactor.core.publisher.Mono;

public interface SCSTExamplePublisherService {
  Mono<Void> createFoo(CreateFooRequestDto requestDto);
  Mono<Void> createBar(CreateBarRequestDto requestDto);
  Mono<Void> createLyn(CreateLynRequestDto requestDto);
  Mono<Void> createRyd(CreateRydRequestDto requestDto);
}
