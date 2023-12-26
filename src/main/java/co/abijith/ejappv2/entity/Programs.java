package co.abijith.ejappv2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programs {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;
private String programName;
private Boolean status;
}
