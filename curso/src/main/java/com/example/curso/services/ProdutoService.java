package com.example.curso.services;

import com.example.curso.dtos.ProdutoDto;
import java.util.List;

public interface ProdutoService {

    ProdutoDto criar(ProdutoDto dto);

    List<ProdutoDto> listar();

    ProdutoDto buscarPorId(Long id);

    ProdutoDto atualizar(Long id, ProdutoDto dto);

    ProdutoDto alterarStatus(Long id, boolean ativo);

    void deletar(Long id);
}
