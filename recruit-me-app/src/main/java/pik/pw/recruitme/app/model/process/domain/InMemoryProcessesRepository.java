package pik.pw.recruitme.app.model.process.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class InMemoryProcessesRepository implements ProcessRepository{

    private ConcurrentHashMap<Integer, Process> map = new ConcurrentHashMap<>();

    @Override
    public Process save(Process process) {

        requireNonNull(process);

        map.put(process.toDTO().getId(), process);

        return process;
    }

    @Override
    public Process findById(Integer id) {

        return map.get(id);
    }

    @Override
    public void deleteById(Integer id) {

        map.remove(id);
    }

    @Override
    public List<Process> findAll() {

        return new ArrayList<>(map.values());
    }
}
