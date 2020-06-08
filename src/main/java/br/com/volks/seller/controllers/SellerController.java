package br.com.volks.seller.controllers;

import br.com.volks.seller.dto.SellerDTO;
import br.com.volks.seller.dto.SellerIdDTO;
import br.com.volks.seller.dto.SellerInsertDTO;
import br.com.volks.seller.services.SellerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class SellerController {

    private final SellerService sellerService;

    @ApiOperation(value = "Inserir um vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendedor inserido com sucesso!"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção.")
    })
    @PostMapping
    public ResponseEntity<SellerDTO> save(@RequestBody SellerInsertDTO dto) {
        SellerDTO seller = sellerService.save(dto);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Listar todos os vendedores")
    @GetMapping
    public ResponseEntity<List<SellerDTO>> getAll() {
        List<SellerDTO> list = new ArrayList<>();
        list = sellerService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Dados do vendedor")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<SellerDTO>> getById(@PathVariable Long id) {
        Optional<SellerDTO> optional;
        try {
            optional = sellerService.findById(id);
            return new ResponseEntity<Optional<SellerDTO>>(optional, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<SellerDTO>>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendedor excluído."),
            @ApiResponse(code = 405, message = "Não foi permitido realizar a exclusão.")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            sellerService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Void>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
