package com.example.teamprojeect.domain.vo.list;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class UserListDTO {
    private boolean isArtist;
    private String artistType;

    public UserListDTO() {this(false, "A");}
}
