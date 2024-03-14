package co.abijith.ejappv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_head_id", nullable = false)
    private AccountHead accountHead;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    private String description;

    private String referenceNumber;

    private String category;

    private String paymentMethod;

    private String status;

}
