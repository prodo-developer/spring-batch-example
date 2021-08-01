package fastcampus.spring.batch.part4.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Level level = Level.NORMAL;

    private int totalAmount;

    private LocalDateTime updateDate;

    @Builder
    private User(String username, int totalAmount) {
        this.username = username;
        this.totalAmount = totalAmount;
    }

    public boolean availabelLevelUp() {
        return Level.availabelLevelUp(this.getLevel(), this.getTotalAmount());
    }

    public Level levelUp() {
        Level nextLevel = Level.getNextLevel(this.getTotalAmount());
        this.level = nextLevel;
        this.updateDate = LocalDateTime.now();

        return nextLevel;
    }
}
