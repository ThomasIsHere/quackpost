package ahiru.quackpost.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="quack_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuackPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreationTimestamp
    private Date createdOn;
    @Column(name="content")
    private String content;
}
