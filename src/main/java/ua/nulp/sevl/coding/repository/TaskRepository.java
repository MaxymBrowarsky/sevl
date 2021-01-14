package ua.nulp.sevl.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.nulp.sevl.coding.model.Label;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.Theme;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTheme(Theme theme);
    List<Task> findByAuthor(String author);

//    @Query("select t from Task t where t.theme_id = ?1")
    //public List<Task> findByThemeId(Long id);

    @Query("select t from Task t where t.labels = ?1")
    public List<Task> findWithLabels(List<Label> labels);
}
