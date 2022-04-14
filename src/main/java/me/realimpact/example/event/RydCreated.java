package me.realimpact.example.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class RydCreated {
  UUID uuid;
  String name2;
  String job2;
  
  @Builder
  public RydCreated(UUID uuid, String name2, String job2) {
    this.uuid = uuid;
    this.name2 = name2;
    this.job2 = job2;
  }
}
