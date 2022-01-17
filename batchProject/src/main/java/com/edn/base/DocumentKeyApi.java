package com.edn.base;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static com.edn.base.SwaggerMessages.*;

public interface DocumentKeyApi {

    @PutMapping("keys/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = UPDATE_DOCS_KEY, notes = UPDATE_DOCS_KEY_NOTE)
    ResponseEntity<List<DocumentKeyResponseTO>> validateKeys(
            @PathVariable int companyId,
            @RequestBody List<DocumentKeyRequestTO> docs);

    @GetMapping("keys")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = GET_DOCS_KEY, notes = GET_DOCS_KEY_NOTE)
    ResponseEntity<Page<DocumentKey>> listKeys(
            @RequestParam(required = false) int companyId,
            @RequestParam(required = false) BigInteger documentKey,
            @RequestParam(required = false, defaultValue = "20") int pageSize,
            @RequestParam(required = false, defaultValue = "0") int pageNumber);

}
