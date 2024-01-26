package co.abijith.ejappv2.entity;

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
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer admissionNo;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;
    private String parentName;
    @NonNull
    private Long mobileNumber;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date doj;
    @Builder.Default
    private String status="Active";

    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<MemberPlans> memberPlansList;

}
