package DTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    String title;
    String description;
    String deadline;
}
