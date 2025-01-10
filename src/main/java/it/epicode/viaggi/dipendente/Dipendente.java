package it.epicode.viaggi.dipendente;

import it.epicode.viaggi.viaggio.prenotazione.Prenotazione;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dipendenti")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

}