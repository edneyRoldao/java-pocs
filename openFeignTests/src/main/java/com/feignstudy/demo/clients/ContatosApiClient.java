package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.ContatoDTO;
import com.feignstudy.demo.dtos.ContatoResponseDTO;
import com.feignstudy.demo.fallbacks.ContatosApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "contatosAPI", url = "${contatosAPI.host}")
public interface ContatosApiClient {

    @GetMapping("api/contatos/{id}")
    Optional<ContatoDTO> getContato(@PathVariable int id);

    @GetMapping("api/contatos/filter")
    List<ContatoDTO> contatosFilter(@RequestParam(required = false) String nome,
                                    @RequestParam(required = false) String tipo,
                                    @RequestParam(required = false) String valor);

    @GetMapping("api/contatos/doc/{doc}")
    List<ContatoDTO> contatosFilter(@PathVariable("doc") String doc);

    @PostMapping("api/contatos")
    Optional<ContatoDTO> insertContato(@RequestBody ContatoDTO contatoDTO);

    @PutMapping("api/contatos/{id}")
    Optional<ContatoResponseDTO> updateContato(@RequestBody ContatoDTO contatoDTO);

    @DeleteMapping("api/contatos/{id}")
    Optional<ContatoResponseDTO> deleteContato(@PathVariable int id);

}
