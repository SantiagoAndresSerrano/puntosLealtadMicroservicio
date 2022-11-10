package ufps.microservicios.puntoslealtad.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "loyalty_points")
@NamedQueries({
        @NamedQuery(name = "LoyaltyPointsEntity.findAll", query = "SELECT e FROM LoyaltyPointsEntity e")})
public class LoyaltyPointsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 250)
    @Column(name = "id_customer")
    private int id_customer;
    @Column(name = "date_point")
    private Date datePoint;

    public LoyaltyPointsEntity(){}
    public LoyaltyPointsEntity(Integer id, int id_customer, Date datePoint) {
        this.id = id;
        this.id_customer = id_customer;
        this.datePoint = datePoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Date getDatePoint() {
        return datePoint;
    }

    public void setDatePoint(Date datePoint) {
        this.datePoint = datePoint;
    }
}
