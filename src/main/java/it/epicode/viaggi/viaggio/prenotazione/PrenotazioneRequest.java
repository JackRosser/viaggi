package it.epicode.viaggi.viaggio.prenotazione;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneRequest {
    @NotNull(message = "Inserisci una data")
    private LocalDate dataRichiesta;
    private String noteDipendente;
    @Min(value = 1, message = "L'id del viaggio non può essere inferiore a 1")
    private Long viaggioId;
    @Min(value = 1, message = "L'id del dipendente non può essere inferiore a 1")
    private Long dipendenteId;
}
