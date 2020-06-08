package br.com.volks.seller.services;

import br.com.volks.seller.dto.SellerDTO;
import br.com.volks.seller.dto.SellerInsertDTO;
import br.com.volks.seller.entities.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {

    List<SellerDTO> getAll();

    Optional<SellerDTO> findById(Long id);

    SellerDTO save(SellerInsertDTO dto);

    void delete(Long id);
}
