package com.jplatform_studiodomino.cms.front.controller;

import com.jplatform_studiodomino.cms.entity.Allegato;
import com.jplatform_studiodomino.cms.service.AllegatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;

@Controller
@RequestMapping("/filesId")
@RequiredArgsConstructor
@Slf4j
public class AllegatoPublicController {

    private final AllegatoService allegatoService;

    @GetMapping("/{id}/{l2}/{filename}")
    public ResponseEntity<InputStreamResource> download(
            @PathVariable Integer id,
            @PathVariable String l2,
            @PathVariable String filename) {

        try {
            Allegato allegato = allegatoService.findById(id).orElseThrow();
            InputStream is = allegatoService.getFileInputStream(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "inline; filename=" + allegato.getL1() + "." + allegato.getType())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(is));
        } catch (Exception e) {
            log.error("Errore download allegato pubblico id={}", id, e);
            return ResponseEntity.notFound().build();
        }
    }
}