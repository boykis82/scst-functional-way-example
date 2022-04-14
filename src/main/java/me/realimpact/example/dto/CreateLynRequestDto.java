package me.realimpact.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateLynRequestDto {
  String name;
  String job;
  
  @Builder
  public CreateLynRequestDto(String name, String job) {
    this.name = name;
    this.job = job;
  }
}
