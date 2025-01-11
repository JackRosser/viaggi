package it.epicode.viaggi.dipendente;

import it.epicode.viaggi.viaggio.prenotazione.Prenotazione;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "dipendenti")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Inserisci qualcosa nell'user")
    @Column(nullable = false)
    private String username;
    @NotBlank(message = "Inserisci qualcosa nel nome")
    @Column(nullable = false)
    private String nome;
    @NotBlank(message = "Inserisci qualcosa nel cognome")
    @Column(nullable = false)
    private String cognome;
    @NotBlank(message = "Inserisci qualcosa nell'email")
    @Email(message = "Inserisci una mail valida")
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String avatar;

}
