package br.com.volks.seller.services.impl;

import br.com.volks.seller.dto.SellerDTO;
import br.com.volks.seller.dto.SellerInsertDTO;
import br.com.volks.seller.entities.Seller;
import br.com.volks.seller.repositories.SellerRepository;
import br.com.volks.seller.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public List<SellerDTO> getAll() {
        List<SellerDTO> listDTO = new ArrayList<>();
        for (Seller seller : sellerRepository.findAll()) {
            listDTO.add(seller.toDTO());
        }
        return listDTO;
    }

    @Override
    public Optional<SellerDTO> findById(Long id) {
        Optional<Seller> opSeller = sellerRepository.findById(id);
        if (opSeller.isPresent()) {
            return opSeller.map(Seller::toDTO);
        }
        return Optional.empty();
    }

    @Override
    public SellerDTO save(SellerInsertDTO dto) {
        Seller seller = sellerRepository.save(dto.toEntity());
        return seller.toDTO();
    }

    @Override
    public void delete(Long id) {
        sellerRepository.deleteById(id);
    }
}
