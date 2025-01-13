package it.epicode.viaggi.dipendente;

import com.cloudinary.Cloudinary;
import com.fasterxml.jackson.databind.util.BeanUtil;
import it.epicode.viaggi.cloudinary.CloudinarySvc;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
@Validated
public class DipendenteSvc {
@Autowired
private  DipendenteRepo dipendenteRepo;
@Autowired
private CloudinarySvc cloudinarySvc;




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

public Dipendente creaDipendente(@Valid Dipendente dipendente) {
    return dipendenteRepo.save(dipendente);
}

// MODIFICA DIPENDENTE

public Dipendente updateDipendente(Long id, @Valid Dipendente modDipendente) {
    Dipendente dipendente = findById(id);
    BeanUtils.copyProperties(modDipendente,dipendente);
    return dipendenteRepo.save(dipendente);
}

// CANCELLA DIPENDENTE

public void deleteDipendente(Long id) {
    dipendenteRepo.deleteById(id);
}

// INSERISCO AVATAR

    public String insertProfilePicture(Long id, MultipartFile file) {
        Dipendente e = findById(id);

        Map result = cloudinarySvc.uploader(file, "profilePictures");
        e.setAvatar((String) result.get("url"));
        dipendenteRepo.save(e);
        return (String) result.get("url");
    }

}
