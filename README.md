# econrich

- Oracle의 HR 스키마의 데이터 사용
- https://github.com/nomemory/hr-schema-mysql/blob/master/hr-schema-mysql.sql

<br>

## 기술 스택

- Java 17
- Springboot 3.0.9
- Gradle
- JPA
- MySQL
- AWS Elastic Beanstalk, EC2, RDS

<br>

## 기능 구현 리스트

- 특정 사원 현재 정보 조회 API
- 특정 사원 이력 정보 조회 API
- 모든 부서 정보 조회 API
- 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 API
- 공공데이터 활용 API (해당 날짜의 박스 오피스 조회)

<br>

## 배포 방법

- AWS Elastic Beanstalk 활용

<br>

## 배포 주소
- 개발 서버 : http://econrich-dev-env-1.eba-b3uqwwmp.ap-northeast-2.elasticbeanstalk.com:5000
- Swagger : http://awskk-env.eba-emhazdpw.ap-northeast-2.elasticbeanstalk.com:5000/swagger-ui/index.html


<br>

## Swagger API 명세 확인 가능

![image](https://github.com/black2code/econrich/assets/93053451/6c3d88d5-60b2-4d39-a581-0a0bb89054cc)

<br>

- 특정 사원 현재 정보 조회
  
<img width="642" alt="image" src="https://github.com/black2code/econrich/assets/93053451/4907150b-fc58-47bb-9e6c-d41e9062a3a6">

<br>

- 특정 사원 이력 정보 조회

<img width="696" alt="image" src="https://github.com/black2code/econrich/assets/93053451/f2d7d181-c355-491f-8ff7-f449ac79a454">

<br>

- 모든 부서 정보 조회

![image](https://github.com/black2code/econrich/assets/93053451/45e5361e-439d-4cb0-80bb-df374cf50355)

<br>

- 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트
- 90번부서에 소속된 사원번호 100번 Steven의 급여가 증가된 내역 확인할 수 있다.

<img width="964" alt="image" src="https://github.com/black2code/econrich/assets/93053451/4f485c55-a167-4619-be1a-78ab6ee3727d">

![image](https://github.com/black2code/econrich/assets/93053451/edff2fb5-2312-4e78-8fb1-e667fbdb9a3d)

<br>

- 공공데이터 활용 API (해당 날짜의 박스 오피스 조회)

<img width="790" alt="image" src="https://github.com/black2code/econrich/assets/93053451/847b48c7-f56a-446d-a835-ab4efd4b9d82">

