package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.Label;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.repository.LabelRepository;
import ua.nulp.sevl.coding.service.LabelService;

import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public void save(Label label) {
        labelRepository.save(label);
    }

    @Override
    public void save(String text, List<Task> tasks) {
        Label label = new Label(text, tasks);
        labelRepository.save(label);
    }

    @Override
    public void delete(Long id) {
        labelRepository.deleteById(id);
    }

    @Override
    public Label update(Long id, String text, List<Task> tasks) {
        Optional<Label> r = labelRepository.findById(id);
        if (r.isPresent()) {
            Label l = r.get();
            return l.setText(text)
                    .setTask(tasks);
        }
        return labelRepository.findById(id).get();
    }

    @Override
    public Label update(Label label) {
        Optional<Label> r = labelRepository.findById(label.getId());
        if (r.isPresent()) {
            Label l = r.get();
            return l.setText(label.getText())
                    .setTask(label.getTask());
        }
        return labelRepository.findById(label.getId()).get();
    }

    @Override
    public Label find(Long id) {
        return labelRepository.findById(id).get();
    }

    @Override
    public List<Label> findAll() {
        return labelRepository.findAll();
    }
}
