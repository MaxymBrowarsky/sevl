package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.Theme;

import java.util.List;

public interface ThemeService {
    void save(Theme theme);
    void save(String text, Task task);
    void delete(Long id);
    Theme update(Long id, String text, Task task);
    Theme update(Theme theme);
    Theme find(Long id);
    List<Theme> findAll();
}
