package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_head_id")
    private AccountHead accountHead;

    @ManyToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;
    @NonNull
    private BigDecimal amount;
    private LocalDate dueDate;

    private String status;
    private String remarks;

}
