package re.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int id;
    private String title;
    private String description;
    private String priority;
    private int assignedTo;
}
