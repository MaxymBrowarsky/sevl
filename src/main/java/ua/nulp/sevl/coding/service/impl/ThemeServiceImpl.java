package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.TestCase;
import ua.nulp.sevl.coding.model.Theme;
import ua.nulp.sevl.coding.repository.ThemeRepository;
import ua.nulp.sevl.coding.service.ThemeService;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public void save(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public void save(String text, Task task) {
        Theme theme = new Theme(text, task);
        themeRepository.save(theme);
    }

    @Override
    public void delete(Long id) {
        themeRepository.deleteById(id);
    }

    @Override
    public Theme update(Long id, String text, Task task) {
        Optional<Theme> r = themeRepository.findById(id);
        if (r.isPresent()) {
            Theme t = r.get();
            return t.setText(text)
                    .setTask(task);
        }
        return themeRepository.findById(id).get();
    }

    @Override
    public Theme update(Theme theme) {
        Optional<Theme> r = themeRepository.findById(theme.getId());
        if (r.isPresent()) {
            Theme t = r.get();
            return t.setText(theme.getText())
                    .setTask(theme.getTask());
        }
        return themeRepository.findById(theme.getId()).get();
    }

    @Override
    public Theme find(Long id) {
        return themeRepository.findById(id).get();
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
