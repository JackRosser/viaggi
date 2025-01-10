package it.epicode.viaggi.viaggio;

import it.epicode.viaggi.viaggio.prenotazione.Prenotazione;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String destinazione;
    @Column(nullable = false)
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Stato statoViaggio;

}
