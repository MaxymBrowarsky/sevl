package ua.nulp.sevl.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nulp.sevl.coding.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
