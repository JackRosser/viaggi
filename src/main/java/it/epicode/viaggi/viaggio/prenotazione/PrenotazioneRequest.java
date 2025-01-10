package it.epicode.viaggi.viaggio.prenotazione;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneRequest {
    private LocalDate dataRichiesta;
    private String noteDipendente;
    private Long viaggioId;
    private Long dipendenteId;
}
