package com.finbit.dpollsapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class Participant {

    @Id
    private String id;

    private String name;
    private Integer[] preferences;
}
