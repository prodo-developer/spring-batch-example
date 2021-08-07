# 대규모서비스를 위한스프링 Cloud와Batch

- Fastcampus에 있는 스프링 배치 프로그램 개발 프로젝트를 통해 진행합니다.
- 스프링배치에 대한 내용을 실습하면서 블로그에 정리하도록 합니다.

## Ch01.스프링배치란
- [X] 01.배치와스프링배치이해
- [X] 02.환경설정및준비
- [X] 03.Hello,SpringBatch
- https://prodo-developer.tistory.com/163
## Ch02.스프링배치아키텍쳐
- [X] 01.스프링배치기본구조
- [X] 02.스프링배치테이블구조와이해
- [X] 03.Job,JobInstance,JobExecution,Step,StepExecution이해
- [X] 04.데이터공유ExecutionContext이해
- https://prodo-developer.tistory.com/162
## Ch03.스프링배치기초이해하기
- [X] 01.Task기반배치와Chunk기반배치
- https://prodo-developer.tistory.com/164
- [X] 02.JobParameters이해
- [X] 03.@JobScope와@StepScope이해
- [X] 04.ItemReaderinterface구조
- [X] 05.CSV파일데이터읽기
- [X] 06.JDBC데이터읽기
- [X] 07.JPA데이터읽기
- https://prodo-developer.tistory.com/166
- [X] 08.ItemWriterinterface구조이해
- [X] 09.CSV파일데이터쓰기
- [X] 10.JDBC데이터쓰기
- [X] 11.JPA데이터쓰기
- https://prodo-developer.tistory.com/167
- [X] 12.ItemProcessorinterface구조이해,과제요구사항설명
- [X] 13.[과제]CSV파일데이터읽고MySQLDB에insert하기
- [X] 14.테스트코드작성하기
- [X] 15.JobExecutionListener,StepExecutionListener이해
- [X] 16.StepListener이해
- [X] 17.skip예외처리
- [X] 18.retry예외처리

## Ch04.회원등급프로젝트
- [X] 01.요구사항이해하기
- [X] 02.회원데이터H2DB에저장하기
- [X] 03.회원주문금액에따른등급적용Step개발
- [X] 04.JobExecutionListener로 대상회원 데이터로그와 실행시간측정
## Ch05.주문금액집계프로젝트
- [X] 01.요구사항이해
- https://prodo-developer.tistory.com/168
- [X] 02.User와 OrdersEntity의 매핑관계개발
- [X] 03.일별주문금액집계Step개발
- [X] 04.JobExecutionDecider로주문금액집계Step실행여부결정
- https://prodo-developer.tistory.com/169
## Ch06.성능개선과성능비교
- [X] 01.성능개선계획이해
- [X] 02.AsyncStep적용하기
- [X] 03.Multi-ThreadStep적용하기
- [X] 04.PartitionStep적용하기
- [X] 05.ParallelStep적용하기
- 
## Ch07.스프링배치설정과실행
- [X] 01.jar생성과실행
- [ ] 02.jenkinsscheduler를이용한스프링배치실행
