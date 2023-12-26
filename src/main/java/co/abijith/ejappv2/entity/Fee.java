package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_member_plan_id")
    private MemberPlans memberPlan;
    @NonNull
    private BigDecimal amount;
    private Date dueDate;
    private String feeType;
    private Date paymentDate;
    private Integer feeForYear;
    private Integer feeForMonth;
    private String transType;

}
