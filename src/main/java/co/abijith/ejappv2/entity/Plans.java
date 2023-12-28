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
@NoArgsConstructor
@AllArgsConstructor
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long fee;
    private String planName;
    @Builder.Default
    private String status="Active";
    @ManyToOne
    @JoinColumn(name = "fk_plan_durat_id")
    private PlanDuration planDuration;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<MemberPlans> memberPlansList;
}
