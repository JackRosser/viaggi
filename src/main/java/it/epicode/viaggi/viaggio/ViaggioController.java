package it.epicode.viaggi.viaggio;

import it.epicode.viaggi.dipendente.Dipendente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
@RequiredArgsConstructor
public class ViaggioController {
    private final ViaggioSvc viaggioSvc;

    // TROVO TUTTI I VIAGGI

    @GetMapping
    public ResponseEntity<List<Viaggio>> listallViaggi() {
        return ResponseEntity.ok(viaggioSvc.findAll());
    }

    // TROVO VIAGGI PER ID

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> findById(@PathVariable Long id) {
        return ResponseEntity.ok(viaggioSvc.findById(id));
    }

    // CREO UN VIAGGIO

    @PostMapping
    public ResponseEntity<Viaggio> creaViaggio(@RequestBody Viaggio viaggio) {
        return ResponseEntity.ok(viaggioSvc.creaViaggio(viaggio));
    }

    // UPDATO VIAGGIO

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggioMod) {
        return ResponseEntity.ok(viaggioSvc.updateViaggio(id, viaggioMod));
    }

    // UCCIDO UN VIAGGIO

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        viaggioSvc.deleteViaggio(id);
        return ResponseEntity.noContent().build();
    }

}
