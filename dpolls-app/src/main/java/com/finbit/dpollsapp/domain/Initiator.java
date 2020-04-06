package com.finbit.dpollsapp.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
public class Initiator {

    @TextIndexed(weight=5) String name;
    @TextIndexed String email;

    private boolean notify;
}
