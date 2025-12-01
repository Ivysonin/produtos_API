package com.example.curso.controllers;

import com.example.curso.dtos.ProdutoDto;
import com.example.curso.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Criar produto
    @PostMapping
    public ResponseEntity<ProdutoDto> criar(@RequestBody ProdutoDto dto) {
        ProdutoDto criado = produtoService.criar(dto);
        return ResponseEntity.ok(criado);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id) {
        ProdutoDto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id,
                                                @RequestBody ProdutoDto dto) {
        ProdutoDto atualizado = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    // Ativar / Desativar produto
    @PatchMapping("/{id}/status")
    public ResponseEntity<ProdutoDto> alterarStatus(@PathVariable Long id,
                                                    @RequestParam boolean ativo) {
        ProdutoDto atualizado = produtoService.alterarStatus(id, ativo);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}