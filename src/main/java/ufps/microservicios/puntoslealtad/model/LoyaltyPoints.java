package ufps.microservicios.puntoslealtad.model;

public class LoyaltyPoints {
    int idCustomer;
    int totalPoints;

    public LoyaltyPoints(int idCustomer, int totalPoints) {
        this.idCustomer = idCustomer;
        this.totalPoints = totalPoints;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
