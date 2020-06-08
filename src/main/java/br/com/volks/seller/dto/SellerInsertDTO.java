package br.com.volks.seller.dto;

import br.com.volks.seller.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO to represent a Seller Entity to create a new one
 */
@Getter
@Setter
@AllArgsConstructor
public class SellerInsertDTO {

    private String firstName;
    private String lastName;
    private String unit;

    /**
     * Parse a DTO to Entity
     * @return Seller
     */
    public Seller toEntity() {
        Seller entity = new Seller();
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setUnit(this.unit);
        return entity;
    }
}
