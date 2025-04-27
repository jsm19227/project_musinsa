## 📖 소개
- [MUSINSA] Java(Kotlin) Backend Engineer - 과제 프로젝트

## 설치 방법
- 프로젝트 클론
git clone https://github.com/jsm19227/project_musinsa.git

## 📖 기술 스택
- JAVA 17
- SPRING Boot 3.3.1 / spring famework 6.1.4
- H2 Database/JPA/QueryDSL
- SpringDoc 2.5

## 📖 주요 기능 및 API 
- SWAGGER
http://localhost:8080/swagger-ui/index.html

- 로컬환경 H2 DB 접근
http://localhost:8080/h2-console
접속 정보
Driver Class: org.h2.Driver
JDBC URL : jdbc:h2:file:./db/mydb
User Name : sa
Password : (빈)

- 구현1) - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
 curl -X 'GET' 'http://localhost:8080/product/category/brand/lowest-price' -H 'accept: \*/\*'

- 구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
조회하는 API
curl -X 'GET' 'http://localhost:8080/product/brand/total-lowest-price' -H 'accept: \*/\*'

- 구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
 curl -X 'GET' 'http://localhost:8080/product/brand/price?categoryName=%EC%83%81%EC%9D%98' -H 'accept: \*/\*'

- 구현 4) 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API
1) 추가
 curl -X 'POST' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json' 
  -d '{
  "brandName": "I",
  "categoryName": "목걸이",
  "price": 55000
}'

3) 수정
 curl -X 'PUT' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json'
  -d '{
  "brandId": 1,
  "productId": 1,
  "brandName": "A",
  "categoryName": "상의",
  "price": 2000
}'

5) 삭제
 curl -X 'DELETE' 'http://localhost:8080/product/brand/manage' -H 'accept: \*/\*' -H 'Content-Type: application/json' 
  -d '{
  "brandId": 1,
  "productId": 1
}'

