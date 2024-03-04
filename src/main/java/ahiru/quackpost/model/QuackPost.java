package ahiru.quackpost.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="quack_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuackPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @CreationTimestamp
    private Date createdOn;
    @Column(name="content")
    private String content;
    @Column(name="user_id")
    private Integer user_id;
}
