package fastcampus.spring.batch.part6;

import fastcampus.spring.batch.part4.repository.UserRepository;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class UserLevelUpPartitioner implements Partitioner {
    private final UserRepository userRepository;

    public UserLevelUpPartitioner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        long minId = userRepository.findMinId(); /* 가장 작은 Id값 (1번) */
        long maxId = userRepository.findMaxId(); /* 가장 큰 Id값 (40,000번) */

        /* 예시 : (40000-1) / 8 + 1 = 5000 */
        long targetSize = (maxId - minId) / gridSize + 1;

        /**
         * 값이 ExecutionContext에 저장
         * partion0 : 1, 5,000
         * partion1 : 5001, 10,000
         * ...
         * partion7 : 35001, 40,000
         */
        Map<String, ExecutionContext> result = new HashMap<>();

        long number = 0;
        long start = minId;
        long end = start + targetSize -1;

        while(start <= maxId) {
            ExecutionContext value = new ExecutionContext();

            result.put("partition" + number, value);

            if (end >= maxId) {
                end = maxId;
            }

            value.putLong("minId", start);
            value.putLong("maxId", end);

            start += targetSize;
            end += targetSize;
            number++;
        }

        return result;
    }
}