package org.example.view;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PostModel {
    private Long id;
    private String title;
    private String text;
    private Long userID;
}
