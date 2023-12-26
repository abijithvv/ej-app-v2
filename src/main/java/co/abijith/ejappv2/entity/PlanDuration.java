package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String planDurationName;
    private Integer monthCount;
    @ManyToOne
    @JoinColumn(name = "fk_program_id")
    private Programs program;
}
