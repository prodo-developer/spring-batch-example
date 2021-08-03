package fastcampus.spring.batch.part4;

import fastcampus.spring.batch.part4.domain.User;
import fastcampus.spring.batch.part4.repository.UserRepository;
import fastcampus.spring.batch.part5.domain.Orders;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaveUserTasklet implements Tasklet {

    private final int ZERO = 0;
    private final int SIZE = 10_000;
    private final UserRepository userRepository;

    public SaveUserTasklet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<User> users = createUsers();

        Collections.shuffle(users);

        userRepository.saveAll(users);

        return RepeatStatus.FINISHED;
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();

        for (int i = ZERO; i < SIZE; i++) {
            users.add(User.builder()
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(1_000)
                            .createdDate(LocalDate.of(2021,8,1))
                            .itemName("item" +i)
                            .build()))
                    .username("test username" + i)
                    .build());
        }

        // SILVER 등급
       for (int i = ZERO; i < SIZE; i++) {
            users.add(User.builder()
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(200_000)
                            .createdDate(LocalDate.of(2021,9,2))
                            .itemName("item" +i)
                            .build()))
                    .username("test username" + i)
                    .build());
        }

        // GOLD 등급
        for (int i = ZERO; i < SIZE; i++) {
            users.add(User.builder()
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(300_000)
                            .createdDate(LocalDate.of(2021,8,3))
                            .itemName("item" +i)
                            .build()))
                    .username("test username" + i)
                    .build());
        }

        // VIP 등급
        for (int i = ZERO; i < SIZE; i++) {
            users.add(User.builder()
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(500_000)
                            .createdDate(LocalDate.of(2021,8,4))
                            .itemName("item" +i)
                            .build()))
                    .username("test username" + i)
                    .build());
        }

        return users;
    }
}