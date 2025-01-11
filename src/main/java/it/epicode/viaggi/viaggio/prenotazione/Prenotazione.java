package it.epicode.viaggi.viaggio.prenotazione;

import it.epicode.viaggi.dipendente.Dipendente;
import it.epicode.viaggi.viaggio.Viaggio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "data_richiesta")
    private LocalDate dataRichiesta;
    @Column(name = "note_dipendente")
    private String noteDipendente;


    @ManyToOne
    @JoinColumn(name = "dipendente")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio")
    private Viaggio viaggio;
}
