package ufps.microservicios.puntoslealtad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufps.microservicios.puntoslealtad.dao.LoyaltyPointsDAO;
import ufps.microservicios.puntoslealtad.entity.LoyaltyPointsEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/api/loyalty", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LoyaltyPointController {
    @Autowired
    LoyaltyPointsDAO loyaltyPointsDAO;

    @GetMapping
    public ResponseEntity<List<LoyaltyPointsEntity>> getAll() {
        return new ResponseEntity<>(loyaltyPointsDAO.findAll(), HttpStatus.OK);
    }
}
