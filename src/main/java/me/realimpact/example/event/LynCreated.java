package me.realimpact.example.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class LynCreated {
  UUID uuid;
  String name;
  String job;
  
  @Builder
  public LynCreated(UUID uuid, String name, String job) {
    this.uuid = uuid;
    this.name = name;
    this.job = job;
  }
}
