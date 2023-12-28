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
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String programName;
    @Builder.Default
    private String status = "Active";

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<PlanDuration> planDurationList;
}
