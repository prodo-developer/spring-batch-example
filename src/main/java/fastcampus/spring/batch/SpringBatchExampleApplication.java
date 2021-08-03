package fastcampus.spring.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchExampleApplication {

	public static void main(String[] args) {
		// 스프링 배치가 정상적으로 종료될 수 있도록 System.exit(SpringApplication.exit();
		System.exit(SpringApplication.exit(SpringApplication.run(SpringBatchExampleApplication.class, args)));
	}

	/**
	 * // TaskExecutor가 기본적으로 Bean으로 생성되어 있기 때문에 기본 @Bean으로 사용하기 위함을 표시
	 */
	@Bean
	@Primary
	TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10); // 쓰레드 기본 사이즈 10
		taskExecutor.setMaxPoolSize(20); // 최대 쓰레드 사이즈 20
		taskExecutor.setThreadNamePrefix("batch-thread-"); // 배치 쓰레드 Prefix 이름이 찍히게 됨.
		taskExecutor.initialize();
		return taskExecutor;
	}
}