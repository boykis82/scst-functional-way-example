package me.realimpact.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateFooRequestDto {
  String title2;
  String comment2;
  
  @Builder
  public CreateFooRequestDto(String title2, String comment2) {
    this.title2 = title2;
    this.comment2 = comment2;
  }
}
