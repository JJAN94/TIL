# 데이터 분석의 중요한 단계 : 데이터 수집

데이터 분석 순서
- 데이터 수집 -> 데이터 유형 및 속성 ㅍ파악 -> 데이터 변환 -> 데이터 저장 -> 데이터 정제 -> 분석 단계

데이터 수집의 일반적인 것 = web에서 정보를 가져오는것


우선 web에 대해 알아보자.

## Web 기본 내용

<img src="C:\Users\JAY\Desktop\TIL\스터디_Python\python_(web&crawling)\client_server.jpg" alt="client_server" style="zoom:50%;" align='left'/>

### Index

- Server & Client Architecture
- URL
- Get & Post
- Internet
- OSI 7 Layer
- cookie & session & cache
- Web Status Code
- Web Language & Framework
- Spider & Bot & Scraping & Crawling



### 1. Server & Client Architecture

- Client
  - 브라우져를 통해 서버에 데이터를 요청
- Server
  - Client가 데이터를 요청하면 요청에 따라 데이터를 전송 



### 2. URL

- Uniform Resource Locator
- `https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=032&aid=0003078429`
  - https:// - Protocol(https에서 s는 secure, 암호화, 복호화를 통해 보안 작업)
  - news - Sub Domain
  - naver.com - Domain (server까지 접근)
  - 80 - port (web service에서 url에 80이 default)
  - /main/ - path
  - read.nhn - page
  - ?mode=LSD&mid=shm&sid1=105&oid=032&aid=0003078429 - query
    - ?가 파일시스템과 쿼리를 구분해주는 것 (mode=LSD는 key=value형태)



### 3. Get & Post

URL에 데이터가 포함되냐 아니냐 여부에 따라 방식이 구분됨.

- Get 방식
  - URL에 데이터가 포함된다(위에 url처럼 query가 포함됨) -> 데이터가 노출
  - 길이 제한이 있음
- Post 방식
  - Body에 데이터가 포함된다 -> 데이터가 숨겨짐



### 4. Internet

- 인터넷이란?
  - 인터넷은 컴퓨터로 연결하여 TCP/IP (Transmission Control Protocol/Internet Protocol)라는 통신 프로토콜을 이용해 정보를 주고받는 컴퓨터 네트워크
- 우리는 인터넷을 어떻게 사용하고 있을까?
  - 해저케이블을 이용하여 전세계 서버에 접속하여 인터넷을 사용하고 있다.
- 무선인터넷
  - 선이 아니라 주파수를 매체로 사용한다.
  - 우리가 사용하는 단말기만 무선이다.



### 5. OSI 7 Layer

- Open Systems Interconnection Reference Model
  - 국제표준화기구(ISO)에서 개발한 모델로, 컴퓨터 네트워크 프로토콜 디자인과 통신을 계층으로 나누어 설명한 것이다.
- 하위 계층으로 갈수록 페이로드가 증가

<img src="C:\Users\JAY\Desktop\TIL\스터디_Python\python_(web&crawling)\osi_model.png" alt="osi_model" style="zoom:50%;" align='left'/>



### 6. cookie & session & cache

- Cookie
  - Client 에 저장하는 문자열 데이터로 도메인 별로 따로 저장
  - 로그인 정보, 내가 봤던 상품 정보, 팝업 다시보지 않음
  - 하나의 클라이언트에 300개, 도메인당 20개, 쿠키 하나당 4Kbyte
- Session
  - Server에 저장하는 객체 데이터, 브라우져와 연결시 Session ID 생성
  - Session ID를 Cookie에 저장함으로 로그인 연결 유지
  - 같은 브라우져로 같은 서버에 접소하면 Session ID가 같음
  - 로그인 연결 정보, 원하는 객체 데이터
- Cache
  - Client나 Server의 메모리에 저장하여 빠르게 데이터를 가져오는 목적의 저장소
  - RAM에 저장하는 개념



### 7. Web Status Code

- 서버와 클라이언트가 데이터를 주고 받으면 주고 받은 결과로 상태코드를 확인 할 수 있다.
- 1xx - information (요청을 받았으며 프로세스를 계속한다.)
- 2xx - success (요청을 성공적으로 받았으며 인식했고 수용하였다.)
- 3xx - redirection (browser cache) (요청 완료를 위해 추가 작업 조치가 필요하다)
- 4xx - request error (요청의 문법이 잘못되었거나 요청을 처리할 수 없다.) 예) 404 error
- 5xx - server error (서버가 명백히 유효한 요청에 대해 충족을 실패했다.)
- http://bit.ly/2nlZM8L (위키백과 HTTP 상태 코드)



### 8. Web Language & Framework

- Client language

  - HTML (웹 구조)
  - CSS - less, sass (웹 스타일)
  - Javascript - vue.js, react.js, angelar.js, backborn.js (웹 이벤트)

- Server

  - Python - Django, Flask
  - Java - Spring
  - Ruby - Rails
  - Javascript - Nodejs (Express)
  - Scala - Play

- Framework

  - module가 package가 모여 library가 된다.

  - library와 Framework의 차이점은 

    - library는 다른사람이 짠 코드, 기능을 가져다가 쓰는 것
    - Framework는 많이 사용하는 기능들을 기본으로 넣고 나머지를 바꿔주면 기능을 실행할 수 있게 해주는 것
    - Framework를 사용하면 짜야 할 코드들이 짧아진다.(양이 적어짐)

    

### 9. Spider &  Bot & Scraping & Crawling

- Scraping

  - 데이터를 수집하는 작업

- Crawling

  - 여러 페이지의 특정 데이터들을 수집하고 분류하는 작업

- Spider or Web crawler

  - 웹 데이터를 수집하는 소프트웨어

- Bot

  - 인터넷 상에서 자동화된 작업을 실행하는 소프트웨어

  예 : google bot, 비트코인 bot(?)











