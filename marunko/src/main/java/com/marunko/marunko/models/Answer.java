package com.marunko.marunko.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel{
    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name = "answer_generator",
            sequenceName = "answer_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    public Answer(){}

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public String getDescription() {
        return description;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", question=" + question +
                '}';
    }
}
