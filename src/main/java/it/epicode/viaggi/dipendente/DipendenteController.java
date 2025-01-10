package it.epicode.viaggi.dipendente;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")

public class DipendenteController {
    @Autowired
    private  DipendenteSvc dipendenteSvc;

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

    @PostMapping
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

}
