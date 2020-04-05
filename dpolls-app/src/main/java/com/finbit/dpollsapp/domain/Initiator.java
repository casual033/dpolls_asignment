package com.finbit.dpollsapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Initiator {

    private String name;
    private String email;
    private boolean notify;
}
