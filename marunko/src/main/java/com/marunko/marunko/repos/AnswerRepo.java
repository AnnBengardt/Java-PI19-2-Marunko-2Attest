package com.marunko.marunko.repos;

import com.marunko.marunko.models.Answer;
import com.marunko.marunko.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
