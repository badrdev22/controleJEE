package org.sid.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Match {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 16,name = "[reference]")
    private String reference;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date matchDate;
    @Column(nullable = false)
    private String lieu;
    @Column(nullable = false)
    private String equipe1;
    @Column(nullable = false)
    private String equipe2;
    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets;

}