package com.finbit.dpollsapp.domain;

import lombok.Data;

@Data
public class Participant {

    private Integer id;

    private String name;
    private Integer[] preferences;
}
