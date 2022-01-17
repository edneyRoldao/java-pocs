package com.feignstudy.demo.fallbacks;

import com.feignstudy.demo.clients.ContatosApiClient;
import com.feignstudy.demo.dtos.ContatoDTO;
import com.feignstudy.demo.dtos.ContatoResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ContatosApiFallback implements ContatosApiClient {

    @Override
    public Optional<ContatoDTO> getContato(int id) {
        return Optional.empty();
    }

    @Override
    public List<ContatoDTO> contatosFilter(String nome, String tipo, String valor) {
        log.info("fallback - contatosFilter");
        return null;
    }

    @Override
    public List<ContatoDTO> contatosFilter(String doc) {
        return null;
    }

    @Override
    public Optional<ContatoDTO> insertContato(ContatoDTO contatoDTO) {
        log.info("fallback - insertContato");
        return Optional.empty();
    }

    @Override
    public Optional<ContatoResponseDTO> updateContato(ContatoDTO contatoDTO) {
        log.info("fallback - updateContato");
        return Optional.empty();
    }

    @Override
    public Optional<ContatoResponseDTO> deleteContato(int id) {
        log.info("fallback - deleteContato");
        return Optional.empty();
    }

}
