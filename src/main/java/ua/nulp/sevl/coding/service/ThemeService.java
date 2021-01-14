package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.Theme;

import java.util.List;
import java.util.Set;

public interface ThemeService {
    void save(Theme theme);
    void save(String text);
    void delete(Long id);
    Theme update(Long id, String text);
    Theme update(Theme theme);
    Theme find(Long id);
    Theme findByText(String text);
    List<Theme> findAll();
}
