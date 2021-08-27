package ru.makhmudov.spring_boot_poll_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.makhmudov.spring_boot_poll_service.enums.QuestionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@RequiredArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    @Column(name = "questiontype")
    QuestionType questionType;

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 255, message = "Length must be 3-255 symbols")
    @NotBlank
    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id")
//    @JsonBackReference
    @JsonIgnore
    Poll poll;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
//    @JsonIgnore
    List<AnswerVariant> answerVariantList;
}
