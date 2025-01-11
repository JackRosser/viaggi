package it.epicode.viaggi.viaggio;

import it.epicode.viaggi.dipendente.Dipendente;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated

public class ViaggioSvc {
    @Autowired
    private  ViaggioRepo viaggioRepo;

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

// CREAZIONE viaggio

    public Viaggio creaViaggio(@Valid Viaggio viaggio) {
        return viaggioRepo.save(viaggio);
    }

// MODIFICA viaggio

    public Viaggio updateViaggio(Long id, @Valid Viaggio modViaggio) {
        Viaggio viaggio = findById(id);
        BeanUtils.copyProperties(modViaggio,viaggio);
        return viaggioRepo.save(viaggio);
    }

// CANCELLA viaggio

    public void deleteViaggio(Long id) {
        viaggioRepo.deleteById(id);
    }


}
