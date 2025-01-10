package it.epicode.viaggi.viaggio;

import it.epicode.viaggi.dipendente.Dipendente;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViaggioSvc {
    private final ViaggioRepo viaggioRepo;

    // TROVA TUTTI GLI UTENTI

    public List<Viaggio> findAll() {
        return viaggioRepo.findAll();
    }

// TROVA GLI UTENTI PER ID

    public Viaggio findById(Long id) {
        if (!viaggioRepo.existsById(id)) {
            throw new EntityNotFoundException("Viaggio non trovato");
        }

        return viaggioRepo.findById(id).get();

    }

// CREAZIONE DIPENDENTE

    public Viaggio creaViaggio(Viaggio viaggio) {
        return viaggioRepo.save(viaggio);
    }

// MODIFICA DIPENDENTE

    public Viaggio updateViaggio(Long id, Viaggio modViaggio) {
        Viaggio viaggio = findById(id);
        BeanUtils.copyProperties(modViaggio,viaggio);
        return viaggioRepo.save(viaggio);
    }

// CANCELLA DIPENDENTE

    public void deleteViaggio(Long id) {
        viaggioRepo.deleteById(id);
    }


}
