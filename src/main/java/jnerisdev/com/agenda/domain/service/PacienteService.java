package jnerisdev.com.agenda.domain.service;

import jnerisdev.com.agenda.domain.entity.Paciente;
import jnerisdev.com.agenda.domain.repository.PacienteRepository;
import jnerisdev.com.agenda.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {


    private final PacienteRepository repository;

    public Paciente salvar(Paciente paciente){

        boolean existeCpf = false;

        Optional<Paciente> optionalPaciente = repository.findByCpf(paciente.getCpf());

        if(optionalPaciente.isPresent()) {
            if (!optionalPaciente.get().getId().equals(paciente.getId())) {
                existeCpf = true;
            }
        }

        if(existeCpf){
            throw new BusinessException("CPF já cadastrado!");
        }

        return repository.save(paciente);
    }

    public List<Paciente> listarTodos(){
        return repository.findAll();
    }

    public Optional <Paciente> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
