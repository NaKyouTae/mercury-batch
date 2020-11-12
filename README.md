# 천하제일 엔행시 대회. (Batch)

## 개발 환경
- OS : Windows
- IDE : Eclipse
- Github
- Java 14
- Spring boot 2.3.0.RELEASE
- JPA
- mariadb
- Gradle

## 기술
- Spring Quartz를 이용하여 Job, Trigger, Schedule을 만들어서 DB로 관리한다.

## 배치 기능
- 뉴스레터
  - 주기 : 매주 월요일 00:00
  - 설명 : 뉴스레터를 구독하는 사용자에게 지난주 도전 내역들과 명예의 전당 정보와 이번주 제시어와 제시어 설명 등등을 담아 전송
  
- 사용자 마일리지 및 등급 변경
  - 주기 : 매주 월요일 00:00
  - 설명 : 지난주 성적에 따라 마일리지 지급과 점수 변경에 따른 등급 변경
  - 마일리지 지금 : 1등 3,000 마일리지, 2등 2,000 마일리지, 1등 1,000 마일리지
  - 등급 : 빨강색(0~999), 주황색(1000~1999), 노랑색(2000~2999), 초록색(3000~3999), 파랑색(4000~4999), 남색(5000~5999), 보라색(6000~7000)
  
- 토큰 삭제
  - 주기 : 매일 00:00
  - 설명 : Refresh Token과 Block Token이 생성된 날짜가 31일 이상인 경우 삭제
  
- 명예의 전당 데이터 생성
  - 주기 : 매주 월요일 00:00
  - 설명 : 삼행시, 이행시의 점수 상위 3개를 명예의 전당에 등록
