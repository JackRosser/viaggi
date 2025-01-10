package it.epicode.viaggi.viaggio.prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneSvc prenotazioneSvc;

    @GetMapping
    public ResponseEntity<List<Prenotazione>> allPrenotazioni() {
        return ResponseEntity.ok(prenotazioneSvc.findAll());
    }

    // TROVO DIPENDENTI PER ID

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> findById(@PathVariable Long id) {
        return ResponseEntity.ok(prenotazioneSvc.findById(id));
    }

    // CREO UN dIPENDENTE

    @PostMapping
    public ResponseEntity<Prenotazione> creaPreno(@RequestBody PrenotazioneDTO prenoRequest) {
        return new ResponseEntity<>(prenotazioneSvc.creaPrenotazione(prenoRequest), HttpStatus.CREATED);
    }

    // UPDATO DIPENDENTE

    @PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione preMod) {
        return ResponseEntity.ok(prenotazioneSvc.updatePrenotazione(id, preMod));
    }

    // UCCIDO UN DIPENDENTE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDip(@PathVariable Long id) {
        prenotazioneSvc.deletePrenotazione(id);
        return ResponseEntity.noContent().build();
    }

}
