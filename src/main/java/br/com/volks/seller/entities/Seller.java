package br.com.volks.seller.entities;

import br.com.volks.seller.dto.SellerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String unit;

    /**
     * Entity to DTO
     * @return SellerDTO
     */
    public SellerDTO toDTO() {
        SellerDTO dto = new SellerDTO(
                this.id,
                this.firstName,
                this.lastName,
                this.unit);
        return dto;
    }
}
