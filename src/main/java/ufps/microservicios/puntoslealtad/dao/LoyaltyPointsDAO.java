package ufps.microservicios.puntoslealtad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ufps.microservicios.puntoslealtad.entity.LoyaltyPointsEntity;
import ufps.microservicios.puntoslealtad.model.LoyaltyPoints;

public interface LoyaltyPointsDAO extends JpaRepository<LoyaltyPointsEntity, Integer > {

    public LoyaltyPointsEntity findLoyaltyPointsEntitiesById_customer(int Id_customer);
}
