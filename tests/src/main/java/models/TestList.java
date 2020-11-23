package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="test_list")
public class TestList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToOne(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    private Test test;

    @OneToMany(mappedBy = "testList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnswer> studentAnswers = new ArrayList<>();

    public TestList(){}

    public TestList(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public void addStudentAnswer(StudentAnswer answer){
        answer.setTestList(this);
        this.studentAnswers.add(answer);
    }

    public void removeStudentAnswer(StudentAnswer answer){
        this.studentAnswers.remove(answer);
    }

    @Override
    public String toString() {
        return "TestList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", schedule=" + schedule +
                ", test=" + test +
                '}';
    }
}
