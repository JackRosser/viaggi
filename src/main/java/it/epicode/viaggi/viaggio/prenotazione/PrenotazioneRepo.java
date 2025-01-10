package it.epicode.viaggi.viaggio.prenotazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    // CONTROLLO STESSA DATA

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.dipendente.id = :dipendenteId AND p.dataRichiesta = :dataRichiesta")
    boolean existsByDipendenteAndDataRichiesta(@Param("dipendenteId") Long dipendenteId, @Param("dataRichiesta") LocalDate dataRichiesta);

}
