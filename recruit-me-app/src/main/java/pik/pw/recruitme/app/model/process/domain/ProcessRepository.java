package pik.pw.recruitme.app.model.process.domain;

import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.springframework.data.repository.Repository;
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException;

import java.util.List;

public interface ProcessRepository extends Repository<Process, Integer> {

    Process save(Process process);

    Process findById(Integer id);

    void deleteById(Integer id);

    List<Process> findAll();

    default Process findByIdOrThrow(Integer id) {

        Process process = findById(id);

        if(process == null){
            throw new ObjectNotFoundException("Process with id" +id);
        }

        return process;
    }
}
