package ufps.microservicios.puntoslealtad.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufps.microservicios.puntoslealtad.config.MessagingConfig;
import ufps.microservicios.puntoslealtad.dao.LoyaltyPointsDAO;
import ufps.microservicios.puntoslealtad.entity.LoyaltyPointsEntity;

import java.util.Date;
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

    @GetMapping("/{idCustomer}")
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public ResponseEntity<List<LoyaltyPointsEntity>> inicializarPoints(@PathVariable int idCustomer) {
        if (loyaltyPointsDAO.findLoyaltyPointsEntitiesById_customer(idCustomer) == null)
            return new ResponseEntity("Ya existe el customer", HttpStatus.BAD_REQUEST);
        LoyaltyPointsEntity loyaltyPointsEntity = new LoyaltyPointsEntity();
        loyaltyPointsEntity.setDatePoint(new Date());
        loyaltyPointsEntity.setId_customer(idCustomer);
        loyaltyPointsDAO.save(loyaltyPointsEntity);
        return new ResponseEntity<>(loyaltyPointsDAO.findAll(), HttpStatus.OK);
    }


}
