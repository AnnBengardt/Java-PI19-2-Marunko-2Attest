package com.marunko.marunko.repos;

import com.marunko.marunko.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
}
