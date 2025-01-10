package it.epicode.viaggi.viaggio.prenotazione;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDTO {
    private LocalDate dataRichiesta;
    private String noteDipendente;
    private Long viaggioId;
    private Long dipendenteId;
}
