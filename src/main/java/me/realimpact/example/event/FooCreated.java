package me.realimpact.example.event;

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class FooCreated {
  UUID uuid;
  String title2;
  String comment2;
  
  @Builder
  public FooCreated(UUID uuid, String title2, String comment2) {
    this.uuid = uuid;
    this.title2 = title2;
    this.comment2 = comment2;
  }
}
