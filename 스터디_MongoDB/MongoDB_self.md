# MongoDB 시작하기

---

# 2장. 몽고DB 기본

- 몽고DB완벽 가이드 기준으로 정리

---

### 몽고DB 셸 

- cmd창에서 mongo라 친다.

- 몽고 셸에서는 자바스크립트 문법을 그대로 사용할 수 있다.

  

- db라 치면 기본적으로 몽고 서버의 test 데이터베이스에 연결하고, 데이터 베이스 연결을 전역 변수 db에 할당한다. 주로 db라는 변수를 통해 몽고db에 접근한다. 

```javascript
> db
test
```



- 데이터베이스 선택 (내가 지은 이름 : StudyMongo), 이제 db는 StudyMongo를 가리킨다.

```javascript
> use StudyMongo
> db
StudyMongo
```

---

### 셸 기본작업 - CRUD

1. **생성**
- insertOne 함수 : 컬렉션에 도큐먼트를 추가한다.
- 우선 도큐먼트를 자타내는 지역변수를 생성하자.

```javascript
> movie = {"title" : "Star Wars : Episode IV - A New Hope",
"direcotr" : "George Lucas", "year" : 1997}

{
        "title" : "Star Wars : Episode IV - A New Hope",
        "direcotr" : "George Lucas",
        "year" : 1997
}
```

- 이제 추가 해주자. (데이터베이스에 저장)

```javascript
> db.StudyMongo.insertOne(movie)

{
        "acknowledged" : true,
        "insertedId" : ObjectId("60c238ddbf72deb48b52525d")
}
```

- 컬렉션에 find를 호출해서 확인 
  - pretty()가 뭐지? => find할때 출력 결과를 예쁘게 표시해준다.(단어뜻그대로네...)

```javascript
> db.StudyMongo.find().pretty()

{
        "_id" : ObjectId("60c238ddbf72deb48b52525d"),
        "title" : "Star Wars : Episode IV - A New Hope",
        "direcotr" : "George Lucas",
        "year" : 1997
}
```





2. **읽기**

- find와 findOne : 컬렉션을 쿼리하는데 사용한다.
- 컬렉션에서 단일 도큐먼트를 읽으려면 findOne 사용

```javascript
> db.StudyMongo.findOne()

{
        "_id" : ObjectId("60c238ddbf72deb48b52525d"),
        "title" : "Star Wars : Episode IV - A New Hope",
        "direcotr" : "George Lucas",
        "year" : 1997
}
```

- find, findOne은 **쿼리 도큐먼트**(query document) 형태로 조건 전달도 가능, 쿼리에서 일치하는 도큐먼트로 결과를 제한 할 수 있다.
- 셸은 find와 일치하는 도큐먼트를 20개까지 자동으로 출력하지만 그 이상도 가져올 수 있다.



3. **갱신**

- undateOne을 사용한다. 
- 매개변수는 최소 2개다. 
  - 첫번째는 수정할 도큐먼트를 찾는 기준, 두번째는 갱신 작업을 설명하는 도큐먼트이다.

- 전에 만들어둔 영화 도큐먼트에 리뷰를 갱신해보자.

```javascript
> db.StudyMongo.updateOne({title : "Star Wars : Episode IV - A New Hope"}, {$set : {reviews: []}})

{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }
```

```javascript
> db.StudyMongo.find().pretty()

{
        "_id" : ObjectId("60c238ddbf72deb48b52525d"),
        "title" : "Star Wars : Episode IV - A New Hope",
        "direcotr" : "George Lucas",
        "year" : 1997,
        "reviews" : [ ]
} // review가 생겼다.
```



4. **삭제**

- deleteOne과 deleteMany는 도큐먼트를 데이터베이스에서 영구적으로 삭제한다.
- 두 함수 모두 필터 도큐먼트로 삭제 조건을 지정한다.
- 필터와 일치하는 모든 도큐먼트를 삭제하려면 deleteMany를 사용한다



- 영화 도큐먼트를 삭제해보자.

```javascript
> db.StudyMongo.deleteMany({"title" : "Star Wars : Episode IV - A New Hope"})

{ "acknowledged" : true, "deletedCount" : 1 }
```

```javascript
> db.StudyMongo.find().pretty()
// 아무것도 안나옴(없으니까)
```



















