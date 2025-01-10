package it.epicode.viaggi.viaggio.prenotazione;

import it.epicode.viaggi.dipendente.Dipendente;
import it.epicode.viaggi.viaggio.Viaggio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private LocalDate dataRichiesta;
    @Column(nullable = false)
    private String noteDipendente;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Viaggio viaggio;
}
