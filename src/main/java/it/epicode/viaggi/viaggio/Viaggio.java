package it.epicode.viaggi.viaggio;

import it.epicode.viaggi.viaggio.prenotazione.Prenotazione;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Inserisci una destinazione")
    private String destinazione;
    @Column(name = "data_partenza")
    @FutureOrPresent(message = "scrivi una data valida")
    private LocalDate dataPartenza;
    @Column(name = "stato_viaggio")
    @Enumerated(EnumType.STRING)
    private Stato statoViaggio;

}
