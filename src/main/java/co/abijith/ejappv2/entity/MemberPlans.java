package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_registration_id")
    private Registration registration;
    @ManyToOne
    @JoinColumn(name = "fk_plan_id")
    private Plans plan;
    @NonNull
    private Date fromDate;
    private Date toDate;
    @Builder.Default
    private String status = "Active";
    private Integer notifyDay;
    private Date lastFeeGeneratedDate;

    @OneToMany(mappedBy = "memberPlan", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;


}
