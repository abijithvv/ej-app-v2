package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String planDurationName;
    private Integer monthCount;
    @ManyToOne
    @JoinColumn(name = "fk_program_id")
    private Programs program;
    @Builder.Default
    private Boolean status = true;

    @OneToMany(mappedBy = "planDuration", cascade = CascadeType.ALL)
    private List<Plans> plansList;
}
