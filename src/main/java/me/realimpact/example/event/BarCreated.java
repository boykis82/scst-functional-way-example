package me.realimpact.example.event;

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class BarCreated {
  UUID uuid;
  String title;
  String comment;
  
  @Builder
  public BarCreated(UUID uuid, String title, String comment) {
    this.uuid = uuid;
    this.title = title;
    this.comment = comment;
  }
}
