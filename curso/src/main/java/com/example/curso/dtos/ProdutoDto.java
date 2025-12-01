package com.example.curso.dtos;

public record ProdutoDto(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Boolean ativo
) {}