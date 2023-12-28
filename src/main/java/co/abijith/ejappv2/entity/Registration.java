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
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer admissionNo;
    private String gender;
    private Date dob;
    private String address;
    @NonNull
    private Long mobileNumber;
    @NonNull
    private Date doj;
    @Builder.Default
    private String status="Active";

    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<MemberPlans> memberPlansList;

}
