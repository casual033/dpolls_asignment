package com.finbit.dpollsapp.dto;

import lombok.Data;

@Data
public class PollSearchDTO {

    private String userName;
    private String userEmail;

    public boolean isNameSearchTermSet() {
        return this.userName != null && this.userName.length() > 0;
    }

    public boolean isEmailSearchTermSet() {
        return this.userEmail != null && this.userEmail.length() > 0;
    }
}
