package ro.sapientia2018.epic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.sapientia2018.epic.model.Epic;

public interface EpicRepository extends JpaRepository<Epic, Long> {

}
