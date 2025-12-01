package com.example.curso.services.impl;

import com.example.curso.dtos.ProdutoDto;
import com.example.curso.models.ProdutoModel;
import com.example.curso.repositorys.ProdutoRepository;
import com.example.curso.services.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository productRepository;

    public ProdutoServiceImpl(ProdutoRepository productRepository) {
        this.productRepository = productRepository;
    }

    // MÉTODOS AUXILIARES

    private ProdutoDto toDto(ProdutoModel produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getAtivo()
        );
    }

    private ProdutoModel toEntity(ProdutoDto dto) {
        return ProdutoModel.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .ativo(true) // sempre ativo ao criar
                .build();
    }

    private ProdutoModel buscarOuFalhar(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }

    @Override
    public ProdutoDto criar(ProdutoDto dto) {
        ProdutoModel novoProduto = toEntity(dto);
        ProdutoModel salvo = productRepository.save(novoProduto);
        return toDto(salvo);
    }

    @Override
    public List<ProdutoDto> listar() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProdutoDto buscarPorId(Long id) {
        ProdutoModel produto = buscarOuFalhar(id);
        return toDto(produto);
    }

    @Override
    public ProdutoDto atualizar(Long id, ProdutoDto dto) {
        ProdutoModel existente = buscarOuFalhar(id);

        existente.setNome(dto.nome());
        existente.setDescricao(dto.descricao());
        existente.setPreco(dto.preco());

        ProdutoModel atualizado = productRepository.save(existente);
        return toDto(atualizado);
    }

    @Override
    public ProdutoDto alterarStatus(Long id, boolean ativo) {
        ProdutoModel existente = buscarOuFalhar(id);

        existente.setAtivo(ativo);

        ProdutoModel atualizado = productRepository.save(existente);
        return toDto(atualizado);
    }

    @Override
    public void deletar(Long id) {
        ProdutoModel existente = buscarOuFalhar(id);
        productRepository.delete(existente);
    }
}