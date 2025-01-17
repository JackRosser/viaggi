package it.epicode.viaggi.dipendente;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import it.epicode.viaggi.cloudinary.CloudinarySvc;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")

public class DipendenteController {
    @Autowired
    private  DipendenteSvc dipendenteSvc;

    @Autowired
    private CloudinarySvc cloudinarySvc;

    // TROVO TUTTI I DIPENDENTI

    @GetMapping
    public ResponseEntity<List<Dipendente>> listAllDipendenti() {
        return ResponseEntity.ok(dipendenteSvc.findAll());
    }

   // TROVO DIPENDENTI PER ID

   @GetMapping("/{id}")
   public ResponseEntity<Dipendente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteSvc.findById(id));
   }

   // CREO UN dIPENDENTE

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Dipendente> creaDipendente(@RequestBody Dipendente dipendente) {
        return ResponseEntity.ok(dipendenteSvc.creaDipendente(dipendente));
    }

    // UPDATO DIPENDENTE

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipMod) {
        return ResponseEntity.ok(dipendenteSvc.updateDipendente(id, dipMod));
    }

    // UCCIDO UN DIPENDENTE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDip(@PathVariable Long id) {
        dipendenteSvc.deleteDipendente(id);
        return ResponseEntity.noContent().build();
    }

    // MOdIfICO AVATAR PER UN DIPENDENTE

    @PatchMapping(path = "/{id}/profilePicture", consumes = "multipart/form-data")
    public ResponseEntity<String> insertProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(dipendenteSvc.insertProfilePicture(id, file), HttpStatus.OK);
    }

}
