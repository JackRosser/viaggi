package it.epicode.viaggi.dipendente;

import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DipendenteSvc {
private final DipendenteRepo dipendenteRepo;

// TROVA TUTTI GLI UTENTI

public List<Dipendente> findAll() {
    return dipendenteRepo.findAll();
}

// TROVA GLI UTENTI PER ID

public Dipendente findById(Long id) {
    if (!dipendenteRepo.existsById(id)) {
        throw new EntityNotFoundException("Dipendente non trovato");
    }

    return dipendenteRepo.findById(id).get();

}

// CREAZIONE DIPENDENTE

public Dipendente creaDipendente(Dipendente dipendente) {
    return dipendenteRepo.save(dipendente);
}

// MODIFICA DIPENDENTE

public Dipendente updateDipendente(Long id, Dipendente modDipendente) {
    Dipendente dipendente = findById(id);
    BeanUtils.copyProperties(modDipendente,dipendente);
    return dipendenteRepo.save(dipendente);
}

// CANCELLA DIPENDENTE

public void deleteDipendente(Long id) {
    dipendenteRepo.deleteById(id);
}


}