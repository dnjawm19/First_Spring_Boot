package com.sparta.week03.dto;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;
}