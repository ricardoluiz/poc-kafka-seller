package br.com.volks.seller.controllers;

import br.com.volks.seller.dto.SellerDTO;
import br.com.volks.seller.dto.SellerIdDTO;
import br.com.volks.seller.services.SellerService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SellerStreamController {

    private final SellerService sellerService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    @KafkaListener(topics = "seller_get_topic")
    public void getSeller(String sellerId) throws Exception {
        // TODO : Implementar tratamento de exceção e validação de seller não encontrado
        System.out.println("Valor que chegou no topico....: " + sellerId);
        SellerIdDTO id = (SellerIdDTO) jsonConverter.fromJson(sellerId, SellerIdDTO.class);
        Optional<SellerDTO> optional;

        optional = sellerService.findById(id.getId());
        if (optional.isPresent()) {
            kafkaTemplate.send("seller_response_topic", jsonConverter.toJson(optional.get()));
        } else {
            kafkaTemplate.send("seller_response_topic", "{}");
        }
    }

}
