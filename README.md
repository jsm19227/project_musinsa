## 📖 소개
- [MUSINSA] Java(Kotlin) Backend Engineer - 과제 프로젝트

## 설치 방법
- 프로젝트 클론<br>
git clone https://github.com/jsm19227/project_musinsa.git

## ⚡주의 사항<br>
빌드 시 data.sql 파일을 항상 실행하게 되면서 이전에 작업해둔 데이터는 모두 삭제되고 초기 데이터가 새로 insert 되는 점 주의<br>
기존 데이터를 유지하고 싶다면 application.properties 파일 설정 중 <br>
spring.sql.init.mode=always 설정은 주석 처리 이후 spring.sql.init.mode=never 주석 해제 

## 📖 기술 스택
- JAVA 17
- SPRING Boot 3.3.1 / spring famework 6.1.4
- H2 Database/JPA/QueryDSL
- SpringDoc 2.5

## 📖 주요 기능 및 API 
- SWAGGER<br>
http://localhost:8080/swagger-ui/index.html

- 로컬환경 H2 DB 접근<br>
http://localhost:8080/h2-console<br>
접속 정보<br>
Driver Class: org.h2.Driver<br>
JDBC URL : jdbc:h2:file:./db/mydb<br>
User Name : sa<br>
Password : (빈)<br>

- 구현1) - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API<br>
 curl -X 'GET' 'http://localhost:8080/product/category/brand/lowest-price' -H 'accept: \*/\*'

- 구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
조회하는 API<br>
curl -X 'GET' 'http://localhost:8080/product/brand/total-lowest-price' -H 'accept: \*/\*'

- 구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API<br>
 curl -X 'GET' 'http://localhost:8080/product/brand/price?categoryName=%EC%83%81%EC%9D%98' -H 'accept: \*/\*'

- 구현 4) 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API<br>
1) 추가<br>
 curl -X 'POST' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json' 
  -d '{
  "brandName": "I",
  "categoryName": "목걸이",
  "price": 55000
}'

2) 수정<br>
 curl -X 'PUT' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json'
  -d '{
  "brandId": 1,
  "productId": 1,
  "brandName": "A",
  "categoryName": "상의",
  "price": 2000
}'

3) 삭제<br>
 curl -X 'DELETE' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json' 
  -d '{
  "brandId": 1,
  "productId": 1
}'

