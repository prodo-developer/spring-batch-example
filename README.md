# 대규모서비스를 위한스프링 Cloud와Batch


## Ch01.스프링배치란
- [X] 01.배치와스프링배치이해
- [X] 02.환경설정및준비
- [X] 03.Hello,SpringBatch
## Ch02.스프링배치아키텍쳐
- [X] 01.스프링배치기본구조
- [X] 02.스프링배치테이블구조와이해
- [ ] 03.Job,JobInstance,JobExecution,Step,StepExecution이해
- [ ] 04.데이터공유ExecutionContext이해
## Ch03.스프링배치기초이해하기
- [ ] 01.Task기반배치와Chunk기반배치
- [ ] 02.JobParameters이해
- [ ] 03.@JobScope와@StepScope이해
- [ ] 04.ItemReaderinterface구조
- [ ] 05.CSV파일데이터읽기
- [ ] 06.JDBC데이터읽기
- [ ] 07.JPA데이터읽기
- [ ] 08.ItemWriterinterface구조이해
- [ ] 09.CSV파일데이터쓰기
- [ ] 10.JDBC데이터쓰기
- [ ] 11.JPA데이터쓰기
- [ ] 12.ItemProcessorinterface구조이해,과제요구사항설명
- [ ] 13.[과제]CSV파일데이터읽고MySQLDB에insert하기
- [ ] 14.테스트코드작성하기
- [ ] 15.JobExecutionListener,StepExecutionListener이해
- [ ] 16.StepListener이해
- [ ] 17.skip예외처리
- [ ] 18.retry예외처리

## Ch04.회원등급프로젝트
- [ ] 01.요구사항이해하기
- [ ] 02.회원데이터H2DB에저장하기
- [ ] 03.회원주문금액에따른등급적용Step개발
- [ ] 04.JobExecutionListener로대상회원데이터로그와실행시간측정
## Ch05.주문금액집계프로젝트
- [ ] 01.요구사항이해
- [ ] 02.User와OrdersEntity의매핑관계개발
- [ ] 03.일별주문금액집계Step개발
- [ ] 04.JobExecutionDecider로주문금액집계Step실행여부결정
## Ch06.성능개선과성능비교
- [ ] 01.성능개선계획이해
- [ ] 02.AsyncStep적용하기
- [ ] 03.Multi-ThreadStep적용하기
- [ ] 04.PartitionStep적용하기
- [ ] 05.ParallelStep적용하기
## Ch07.스프링배치설정과실행
- [ ] 01.jar생성과실행
- [ ] 02.jenkinsscheduler를이용한스프링배치실행
