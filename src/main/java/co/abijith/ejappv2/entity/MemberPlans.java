package co.abijith.ejappv2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonBackReference
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "fk_plan_id")
    @JsonBackReference
    private Plans plan;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    @Builder.Default
    private String status = "Active";

    @NonNull
    private Integer notifyDay;

    private Date lastFeeGeneratedDate;

}
