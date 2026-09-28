# Virtual Thread Experiment

Java 21 Virtual Thread와 Platform Thread의 동시성 처리 차이를 확인하기 위한 테스트

## 목적

- Platform Thread Pool과 Virtual Thread의 동작 방식 비교
- Blocking I/O 상황에서 동시 처리 차이 확인
- Thread Pool 크기에 따른 처리 시간 변화 확인

## 조건

- Java 21
- 작업 수: 10,000개
- 각 작업: `Thread.sleep(1000)`
- Platform Thread: FixedThreadPool
- Virtual Thread: VirtualThreadPerTaskExecutor

## 테스트결과

-정리 예정
