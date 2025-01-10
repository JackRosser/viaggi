package it.epicode.viaggi.viaggio.prenotazione;

import it.epicode.viaggi.dipendente.Dipendente;
import it.epicode.viaggi.dipendente.DipendenteSvc;
import it.epicode.viaggi.viaggio.Viaggio;
import it.epicode.viaggi.viaggio.ViaggioSvc;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneSvc {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;
    @Autowired
    private DipendenteSvc dipendenteSvc;
    @Autowired
    private ViaggioSvc viaggioSvc;

    public List<Prenotazione> findAll() {
        return prenotazioneRepo.findAll();
    }

    public Prenotazione findById(Long id) {
        if (!prenotazioneRepo.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione non trovato");
        }

        return prenotazioneRepo.findById(id).get();

    }


    public Prenotazione creaPrenotazione(PrenotazioneDTO prenotazioneDto) {
        Prenotazione prenotazione = new Prenotazione();
        BeanUtils.copyProperties(prenotazioneDto, prenotazione);
        Viaggio viaggio = viaggioSvc.findById(prenotazioneDto.getViaggioId());
        Dipendente dipendente = dipendenteSvc.findById(prenotazioneDto.getDipendenteId());
        prenotazione.setViaggio(viaggio);
        prenotazione.setDipendente(dipendente);
        return prenotazioneRepo.save(prenotazione);
    }


    public Prenotazione updatePrenotazione(Long id, Prenotazione modPrenotazione) {
        Prenotazione prenotazione = findById(id);
        BeanUtils.copyProperties(modPrenotazione,prenotazione);
        return prenotazioneRepo.save(prenotazione);
    }


    public void deletePrenotazione(Long id) {
        prenotazioneRepo.deleteById(id);
    }

}
