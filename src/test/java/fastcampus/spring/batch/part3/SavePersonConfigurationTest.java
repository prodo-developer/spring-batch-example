package fastcampus.spring.batch.part3;

import fastcampus.spring.batch.TestConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBatchTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SavePersonConfiguration.class, TestConfiguration.class})
class SavePersonConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private PersonRepository personRepository;

    @AfterEach
    public void tearDown() throws Exception{
        personRepository.deleteAll();
    }

    @Test
    public void test_step() {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("savePersonStep");

        assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())// Write의 sum값
                .isEqualTo(personRepository.count()) //레파지토리 카운트 값
                .isEqualTo(3); // 모두 3인지 확인
    }

    @Test
    public void test_allow_duplicate() throws Exception {
        //given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplicate", "false")
                .toJobParameters();

        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        //then
        assertThat(jobExecution.getStepExecutions().stream()
            .mapToInt(StepExecution::getWriteCount)
            .sum())// Write의 sum값
            .isEqualTo(personRepository.count()) //레파지토리 카운트 값
            .isEqualTo(3); // 모두 3인지 확인
    }

    @Test
    public void test_not_allow_duplicate() throws Exception {
        //given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplicate", "true")
                .toJobParameters();

        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        //then
        assertThat(jobExecution.getStepExecutions().stream()
            .mapToInt(StepExecution::getWriteCount)
            .sum())// Write의 sum값
            .isEqualTo(personRepository.count()) //레파지토리 카운트 값
            .isEqualTo(100); // 모두 3인지 확인
    }
}