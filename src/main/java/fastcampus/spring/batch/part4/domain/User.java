package fastcampus.spring.batch.part4.domain;

import fastcampus.spring.batch.part5.domain.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

//    private int totalAmount;
    /**
     * 1:N 관계
     * user는 n개의 Orders를 가질 수 있다.
     * user가 저장되면서 Orders를 같이 저장할 수 있도록 영속성 전이(PERSIST)를 적용한다.
     *
     * 멀티쓰레드 환경에서 여러 쓰레드가 Lazy설정 된 엔티티로 접근하게 되면 Lazy로딩 에러가 발생할 수 있음
     * fetch = FetchType.EAGER 적용을 통해 해결
     * user와 orders의 항상 조회하는 경우에만 사용을 했지만 되도록이면 지연로딩을 권장한다.
    **/
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Orders> orders;

    private LocalDate updatedDate;

    @Builder
    private User(String username, List<Orders> orders) {
        this.username = username;
        this.orders = orders;
    }

    public boolean availableLeveUp() {
        return Level.availableLevelUp(this.getLevel(), this.getTotalAmount());
    }

    private int getTotalAmount() {
        return this.orders.stream()
                .mapToInt(Orders::getAmount)
                .sum();
    }

    public Level levelUp() {
        Level nextLevel = Level.getNextLevel(this.getTotalAmount());
        this.level = nextLevel;
        this.updatedDate = LocalDate.now();

        return nextLevel;
    }
}
