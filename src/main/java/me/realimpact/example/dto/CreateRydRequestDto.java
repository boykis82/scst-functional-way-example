package me.realimpact.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateRydRequestDto {
  String name2;
  String job2;
  
  @Builder
  public CreateRydRequestDto(String name2, String job2) {
    this.name2 = name2;
    this.job2 = job2;
  }
}
