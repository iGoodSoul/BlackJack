package by.vasiliev.blackjack.controllers;

import by.vasiliev.blackjack.models.Hand;
import by.vasiliev.blackjack.services.DealerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/dealer")
public class DealerController {

    @Autowired
    DealerServiceImpl dealerService;


    @GetMapping("deal")
    public ResponseEntity<Map<String, Hand>> deal(){
        return new ResponseEntity<>(dealerService.deal(), HttpStatus.OK);
    }

    @GetMapping("decks")
    public ResponseEntity<Integer> getNumberOfCards(){
        return new ResponseEntity<>(dealerService.getNumberOfCards(),HttpStatus.OK);
    }

    @GetMapping("hit")
    public ResponseEntity <Hand> hitDealer(){
        return new ResponseEntity<>(dealerService.hitDealer(), HttpStatus.OK);
    }
}