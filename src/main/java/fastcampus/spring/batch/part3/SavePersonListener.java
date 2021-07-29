package fastcampus.spring.batch.part3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;

/**
 * JobExecutionListener이용한 인터페이스
 */

@Slf4j
public class SavePersonListener {

    public static class SavePersonStepExecutionListener {
        @BeforeStep
        public void beforeStep(StepExecution stepExecution) {
            log.info("beforeStep");
        }

        @AfterStep
        public ExitStatus afterStep(StepExecution stepExecution) {
            log.info("afterStep : {}" + stepExecution.getWriteCount());
            return stepExecution.getExitStatus();
        }
    }

    public static class SavePersonJobExecutionListener implements JobExecutionListener {

        // job 실행 전에 호출
        @Override
        public void beforeJob(JobExecution jobExecution) {
            log.info("beforeJob");
        }

        // job 실행 후에 호출
        @Override
        public void afterJob(JobExecution jobExecution) {
            int sum = jobExecution.getStepExecutions().stream()
                    .mapToInt(StepExecution::getWriteCount)
                    .sum();
            log.info("afterJob :{}", sum);
        }
    }

    public static class SavePersonJobAnnotationJobExecutionListener {
        // job 실행 전에 호출
        @BeforeJob
        public void beforeJob(JobExecution jobExecution) {
            log.info("AnnotationBeforeJob");
        }

        // job 실행 후에 호출
        @AfterJob
        public void afterJob(JobExecution jobExecution) {
            int sum = jobExecution.getStepExecutions().stream()
                    .mapToInt(StepExecution::getWriteCount)
                    .sum();
            log.info("AnnotationAfterJob :{}", sum);
        }
    }
}