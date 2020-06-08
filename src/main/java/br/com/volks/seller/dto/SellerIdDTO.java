package br.com.volks.seller.dto;

import br.com.volks.seller.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO with only Seller Id for Kafka topic
 */
public class SellerIdDTO {

    private Long id;

    public SellerIdDTO() { }

    public SellerIdDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
