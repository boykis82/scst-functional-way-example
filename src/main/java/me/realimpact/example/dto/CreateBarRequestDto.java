package me.realimpact.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateBarRequestDto {
  String title;
  String comment;
  
  @Builder
  public CreateBarRequestDto(String title, String comment) {
    this.title = title;
    this.comment = comment;
  }
}
