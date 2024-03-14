package co.abijith.ejappv2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Programs program;

    @Builder.Default
    private String status = "Active";

    @OneToMany(mappedBy = "planDuration", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plans> plansList;
}
