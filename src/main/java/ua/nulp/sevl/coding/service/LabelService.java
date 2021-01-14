package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Label;
import ua.nulp.sevl.coding.model.Task;

import java.util.List;

public interface LabelService {
    void save(Label label);
    void save(String text);
    void delete(Long id);
    Label update(Long id, String text);
    Label update(Label label);
    Label find(Long id);
    Label findByText(String text);
    List<Label> findAll();
}
