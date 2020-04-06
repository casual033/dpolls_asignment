package com.finbit.dpollsapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PollSearchDTO {

    private String searchTerm;
    private LocalDate afterDate;
    private LocalDate beforeDate;
}
