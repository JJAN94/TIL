# 몽고디비 시작하기

| Introduction              | Developers      | Administrators   | Reference        |
| ------------------------- | --------------- | ---------------- | ---------------- |
| Introduction to MongoDB   | CRUD Operations | Production Notes | Shell Methods    |
| Installation Guides       | Aggregation     | Replica Sets     | Query Operations |
| Databases and Collections | SQL to MongoDB  | Sharded Clusters | Reference        |
| Documents                 | Indexes         | MongoDB Security | Glossary         |



Replica Sets, Sharded Clusters 가 몽고의 핵심

- 메모리 분할 단위 Chunk
  - MongoDB partitions sharded data into [chunks](https://docs.mongodb.com/manual/reference/glossary/#std-term-chunk). Each chunk has an inclusive lower and exclusive upper range based on the [shard key](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard-key).
  - A contiguous range of [shard key](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard-key) values within a particular [shard](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard). Chunk ranges are inclusive of the lower boundary and exclusive of the upper boundary. MongoDB splits chunks when they grow beyond the configured chunk size, which by default is 64 megabytes. MongoDB migrates chunks when a shard contains too many chunks of a collection relative to other shards. See [Data Partitioning with Chunks](https://docs.mongodb.com/manual/core/sharding-data-partitioning/#std-label-sharding-data-partitioning) and [Sharded Cluster Balancer](https://docs.mongodb.com/manual/core/sharding-balancer-administration/#std-label-sharding-balancing).



---

몽고 설치 경로

C:\Program Files\MongoDB\Server\4.4\bin



---

1. 질의 : 하나의 쿼리를 명시하는 키워드, mongoDB는 6개 정도의 질의를 가진다.

   - 키-값 질의 : 특정 필드와 맵핑되는 값을 포함하는 문서 { }를 말한다.

      ​					주 key에 대한 값을 리턴하는 경우

   - 범위 : 특정 범위에 포함되는 값을 말한다. (비교연산자) (예 : value가 50이상 100미만인 경우)

   - 공간질의 : 선, 원 다각형 등에 대한 공간 근사값

   - 문자열 탐색질의 : 논리연산자를 통해서 특정 문자열을 탐색 (예 : 문장에서 긍정 단어는 몇개인가? 맵리듀스~)

   - 집합 질의 : 그룹함수를 지칭하며 count, min, max, average등 을 이용한 결과값

   - MR (Map Reduce Query)

      - 쿼리, 파일, DB를 분철(분철된 데이터에 1을 부여) -> 정렬 -> 집계

      - JavaScript로 표현되는 복잡한 데이터를 데이터베이스로 실행 해 반환하는 질의

      - 분산시스템의 기준

         

2. 컬렉션 규칙 및 키에 대한 필드 몇 생성 조건

   - $로 시작할 수 없다.

   - 대소문자를 구분한다

   - 255자(크기) 이내로 작성한다.

   - . 연산자를 포함 할 수 없다.

   - 공백이 중간에 들어갈 수 없다.

   - 필드 이름은 하나의 컬렉션 내에서 유일한 값

   - 전체 문서(한줄한줄=문서->모든 줄=전체문서)의 크기가 16M(메가) 로 제한되어있다.(네트워크 대역폭으로 제한, 넘어가면 overflow로 연결을 끊어버린다.)

   - 만일 문서가 대용량(16M 이상)이면 GridFS api(대용량 데이터 처리)를 사용해서 구현한다.

     

3. 문서에 대한 정보 (외부적인 상태)

   - mongod.lock : 서버의 프로세스 ID를 저장한다. 데이터를 주고받을 때는 락이 걸어둔다. lock이 생기면 연동가능

   - .0 파일(.ns) : 메타데이터를 네임스페이스 단위(.숫자)로 저장한다.

   - 2번의 크기는 ns 16M를 넘을 수 없다. 

     28000개 정도의 네임스페이스(하나의 데이터 베이스는 컬렉션과 색인 수를 28000개를 가진다.)

     --nssize arg(=16) : defaullt 16

   - test.0(64M), test.1(128M)같은 식으로 데이터 저장소를 확보해서 데이터를 저장한다고 간주하면? 

     => 파일 용량은 2GB까지가 최대이다.(--nssize arg 2G / .0 , .1로 별칭을 줘서 관리한다.)

   - 몽고는 데이터 저장소 크기를 정적으로 관리한다.

   "C:\Program Files\MongoDB\Server\4.4\bin\mongod.exe" --config "C:\Program Files\MongoDB\Server\4.4\bin\mongod.cfg" --service

   

4. 문서에 대한 정보 (내부적인 상태)
   - --db.stats(1042); : 자료를 입력했을 때 몽고 드라이버가 동작된 후 데이터 상태확인, 외부에서 클라이언트가 접근할 수 있게 해줌
   - 자료를 입력 했을 때 몽고 드라이버가 동작된다.
     - mongodb에 삽입되는 문서의 고유 번호 ID인 _id로 필드와 값을 생선한다.
     - 문서를 mongodb의 bson으로 변환한다. (데이터 타입을 바이너리 json형태로 변환)
     - 네트워크 소켓을 이용해서 데이터베이스로 전달(저장)



---

\[실습]

1. 서비스에서 mongo 서버를 중단

2. c:\data\mydata 폴더를 생성

3. my.log, my.cfg 파일을 생성한다.

   c:\data\log\my.log

   c:\data\cfg\my.cfg

4. 해당 로그 파일을 저장 할 때 사용자가 지정하는 특정 위치를 사용하도록 지정한다. (관리자 권한 cmd)

   ```
   echo logpath = "c:\data\log\my.log" > "c:\data\cfg\my.cfg"
   ```

5. db path를 지정한다. 서비스에 이름도 등록하자. <윈도우 서비스에서 등록확인>

   ```
   mongod --dbpath "c:\data\mydata" --logpath "c:\data\cfg\my.cfg" --install --serviceName MyMongo --serviceDisplayName MyMongo
   ```

6. 삭제

   ```
   mongod --dbpath --dbpath "c:\data\mydata" --logpath "c:\data\cfg\my.cfg" --remove
   ```

7. 시작/중지

   ```
   Net start MyMongo                
   Net stop MyMongo
   ```

---

```
mongod help
```

mongo 접속

```
[cmd]

> mongo
```



- 빅데이터를 한다? => txt, sql, csv, tsv, xml, json 끼리는 호환(서로 변환)을 시킬 줄 알아야한다.

---

몽고시작~



```mongodb
// insert를 해보자
> db.exam.insert({a : "a"})
WriteResult({ "nInserted" : 1 })

// exam에 있는걸 찾아보자
> db.exam.find()
{ "_id" : ObjectId("60c1aa666daf7c6cd8192448"), "a" : "a" }

// exam02라는 collection을 만들어보자
> db.createCollection("exam02");
{ "ok" : 1 }

// 현재 만들어진 컬렉션의 내용을 확인 해보자.
> db.getCollectionNames()
[ "exam", "exam02" ]

// exam02 상태를 보자
> db.exam02.stats()
> db.printCollectionStats() //이건 전체 collection나옴

```



Q) 테이블을 생성 한 후 데이터를 입력 해보자.

```sql
-- 오라클
CREATE TABLE MY(
USER_ID VARCHAR2(2), AGE NUMBER, STATUS VARCHAR2(5));
INSERT INTO MY VAULES('AAA', 23,'A')
```

```
> db.my.insert({user_id : "aaa", age : 23, status : "A"})
WriteResult({ "nInserted" : 1 })

> db.my.insert( [{user_id : "bbb", age : 40, status : "B"}, 
				{user_id : "ccc", age : 31, status : "C"}, 
				{user_id : "dd", age : 44, status : "D"}, 
				{user_id : "eee", age : 17, status : "E"}, 
				{user_id : "fa", age : 21, status : "F"}])
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "nInserted" : 5,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

Q) nums 테이블을 만들어서 숫자를 입력해보자.

```javascript
> db.nums.save({num: 100000})
> db.nums.save({num : NumberInt(100000)})
> db.nums.save({num : NumberLong(100000)})
> db.nums.find()

{ "_id" : ObjectId("60c1ae866daf7c6cd819244f"), "num" : 100000 }
{ "_id" : ObjectId("60c1ae8a6daf7c6cd8192450"), "num" : 100000 }
{ "_id" : ObjectId("60c1ae8e6daf7c6cd8192451"), "num" : NumberLong(100000) }

```

```javascript
// int32 자료형
> db.nums.find({num:{$type:16}})
{ "_id" : ObjectId("60c1ae8a6daf7c6cd8192450"), "num" : 100000 }

// int64 자료형
> db.nums.find({num:{$type:18}}) 
{ "_id" : ObjectId("60c1ae8e6daf7c6cd8192451"), "num" : NumberLong(100000) }

// double형 자료형
> db.nums.save({num : 98.9})
> db.nums.find({num:{$type:1}})
```



Q) new Date() 객체를 입력해보자.

```javascript
> db.nums.save({num:new Date()})
> db.nums.save({num:new Date()+1})
```



Q) typeof 객체의 타입을 확인 해보자. date 객체를 찾아보자.

```javascript
> typeof new Date()

> db.nums.find({num:{$type:2}})
{ "_id" : ObjectId("60c1b7f56daf7c6cd8192453"), "num" : "Thu Jun 10 2021 15:57:57 GMT+09001" }

> db.nums.find({num:{$type:9}})
{ "_id" : ObjectId("60c1b7ec6daf7c6cd8192452"), "num" : ISODate("2021-06-10T06:57:48.413Z") }

> db.nums.find()
{ "_id" : ObjectId("60c1ae866daf7c6cd819244f"), "num" : 100000 }
{ "_id" : ObjectId("60c1ae8a6daf7c6cd8192450"), "num" : 100000 }
{ "_id" : ObjectId("60c1ae8e6daf7c6cd8192451"), "num" : NumberLong(100000) }
{ "_id" : ObjectId("60c1b7ec6daf7c6cd8192452"), "num" : ISODate("2021-06-10T06:57:48.413Z") } //$type:9
{ "_id" : ObjectId("60c1b7f56daf7c6cd8192453"), "num" : "Thu Jun 10 2021 15:57:57 GMT+09001" } //$type:2
```













---

20210610 오늘 봐야할것

- reference를 읽어보자.
  - Aggregation Command
- The mongo Shell
