package jnerisdev.com.agenda.api.controller;

import jnerisdev.com.agenda.domain.entity.Paciente;
import jnerisdev.com.agenda.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {
    
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
        Paciente pacienteSalvo = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

}
