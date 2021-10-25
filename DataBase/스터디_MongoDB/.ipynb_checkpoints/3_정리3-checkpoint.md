# 3일차 몽고

 txt, csv(tsv), json, xml, sql(pandas, hive, spark)



Q1) Product의 전체 내용을 출력 해보자. 단, _id는 빼고

```javascript
db.Product.find({},{_id:0})
```



Q2) ID와 가격을 출력해보자. (aggregation)

```javascript
db.Product.aggregate([{
		$project:{_id:1, Price:1}
		}]);

db.Product.aggregate([{
		$project:{Price:1}
		}]);

{ "_id" : ObjectId("60c8045b08acd45ff3d2fd03"), "Price" : 200 }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd04"), "Price" : 80 }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd05"), "Price" : 220 }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd06"), "Price" : 200 }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd07"), "Price" : 100 }
```



Q3) 이름과 가격만 출력해보자.

```javascript
db.Product.aggregate([{
	$project:{_id:0, Name:1, Price:1}
	}])

{ "Name" : "notebook", "Price" : 200 }
{ "Name" : "pencil", "Price" : 80 }
{ "Name" : "salad", "Price" : 220 }
{ "Name" : "others", "Price" : 200 }
{ "Name" : "bread", "Price" : 100 }
```



Q4) 가격과 카테고리만 출력하자. 단 가격별 오름차순으로 정렬해보자.

```javascript
db.Product.aggregate([
	{$project:{Price:1, Category:1, _id:0}},
	{$sort:{Price:1}}
])

{ "Price" : 80, "Category" : "material" }
{ "Price" : 100, "Category" : "food" }
{ "Price" : 200, "Category" : "material" }
{ "Price" : 200, "Category" : "material" }
{ "Price" : 220, "Category" : "food" }
```



Q5) 이름(목록)과 가격만 출력하되 목록을 내림차순으로 정렬해보자.

```javascript
db.Product.aggregate([
	{$project:{Name:1, Price:1, _id:0}},
	{$sort:{Name:-1}}
])

{ "Name" : "salad", "Price" : 220 }
{ "Name" : "pencil", "Price" : 80 }
{ "Name" : "others", "Price" : 200 }
{ "Name" : "notebook", "Price" : 200 }
{ "Name" : "bread", "Price" : 100 }
```



- 별칭 주기 -> $project만 별칭을 줄 수 있다.

Q6) $project로 가서 별칭을 주는 것을 확인 후 아래와 같이 이름(목록만) 출력해보자.

```javascript
db.Product.aggregate([
	{$project:{_id:0, alias_name:"$Name"}}
])

{ "alias_name" : "notebook" }
{ "alias_name" : "pencil" }
{ "alias_name" : "salad" }
{ "alias_name" : "others" }
{ "alias_name" : "bread" }
```



Q7) Name을 목록, Price 가격, Category는 타입으로 별칭을 주자.

```javascript
db.Product.aggregate([
	{$project:{_id:0, 목록:"$Name", 가격:"$Price", 타입:"$Category"}}
])

{ "목록" : "notebook", "가격" : 200, "타입" : "material" }
{ "목록" : "pencil", "가격" : 80, "타입" : "material" }
{ "목록" : "salad", "가격" : 220, "타입" : "food" }
{ "목록" : "others", "가격" : 200, "타입" : "material" }
{ "목록" : "bread", "가격" : 100, "타입" : "food" }
```



Q8) 상품의 목록을 출력하고 inc_price라는 별칭을 주고 가격에 100을 더한 값을 추가하자. ($add)

```javascript
db.Product.aggregate([
	{$project:{_id:0, Name:1, 
	 inc_price:{$add:["$Price",100]}}}
])

{ "Name" : "notebook", "inc_price" : 300 }
{ "Name" : "pencil", "inc_price" : 180 }
{ "Name" : "salad", "inc_price" : 320 }
{ "Name" : "others", "inc_price" : 300 }
{ "Name" : "bread", "inc_price" : 200 }
```



Q9) $max, $group

카테고리로 그룹화를 한다음 최대 가격을 출력 해보자.

```javascript
db.Product.aggregate([
    {$group:{_id:"$Category", max_price:{$max:"$Price"}}}
])

{ "_id" : "food", "max_price" : 220 }
{ "_id" : "material", "max_price" : 200 }
```

Q10) $min, $group

카테고리로 그룹화를 한다음 최소 가격을 출력 해보자.

```javascript
db.Product.aggregate([
    {$group:{_id:"$Category", min_price:{$min:"$Price"}}}
])

{ "_id" : "food", "min_price" : 100 }
{ "_id" : "material", "min_price" : 80 }
```



Q11) 상품 목록을 출력하고 가격의 합과 가격의 평균 및 목록의 개수를 구하자.

```javascript
db.Product.aggregate([
    {$group:{_id:"$Category", sum:{$sum:"$Price"},avg:{$avg:"$Price"}, count:{$sum:1}}}
])

{ "_id" : "material", "sum" : 480, "avg" : 160, "count" : 3 }
{ "_id" : "food", "sum" : 320, "avg" : 160, "count" : 2 }
```



Q12) 상품목록을 출력하고 그룹화 한 다음 개수를 구해보자.

```javascript
db.Product.aggregate([
    {$group:{_id:"$Category", count:{$sum:1}}}
])

{ "_id" : "food", "count" : 2 }
{ "_id" : "material", "count" : 3 }
```

(같은결과 다른방법)

```javascript
db.Product.aggregate([
	{$project:{"Category":1, count:{$literal:1}}},
	{$group:{_id:"$Category", count:{$sum:"$count"}}}
])
// $literal 도움말 보자

{ "_id" : "food", "count" : 2 }
{ "_id" : "material", "count" : 3 }
```



Q13) Name에서 bread를 찾아서 출력하자.

```javascript
db.Product.aggregate([
		{$project:{_id:0, Name:1}}, {$match:{Name:"bread"}}
])

{ "Name" : "bread" }
```



Q14) Category에서 food만 출력해보자.

```javascript
db.Product.aggregate([
    {$match:{Category:"food"}}
])

{ "_id" : ObjectId("60c8045b08acd45ff3d2fd05"), "Name" : "salad", "Price" : 220, "Category" : "food" }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd07"), "Name" : "bread", "Price" : 100, "Category" : "food" }
```



Q15) Category에서 food가격의 최대, 최소, 합, 평균, 개수를 출력해보자.

```javascript
db.Product.aggregate([
    {$match:{Category:"food"}},
	{$group :{_id:"$Category", max:{$max:"$Price"}, min:{$min:"$Price"}, sum:{$sum:"$Price"}, avg:{$avg:"$Price"}, count:{$sum:1}}}
])

{ "_id" : "food", "max" : 220, "min" : 100, "sum" : 320, "avg" : 160, "count" : 2 }

db.Product.aggregate([
    {$group:{_id:"$Category",
             max:{$max:"$Price"},
             min:{$min:"$Price"},
             sum:{$sum:"$Price"},
             avg:{$avg:"$Price"},
             count:{$sum:1}}}, {$match:{_id:"food"}}
])
{ "_id" : "food", "max" : 220, "min" : 100, "sum" : 320, "avg" : 160, "count" : 2 }
```



Q16) 15번을 코드로 작성 해보자

```javascript
function map(){
	emit(this.Category, {sum:this.Price, min:this.Price, max:this.Price, count:1});
}

function reduce(key, values){
    var result = {Category:key, sum:0, min:10000, max:0, count:0}
    values.forEach(function(v){
        result.count += v.count;
        result.sum += v.sum;
        result.min = Math.min(v.min, result.min);
        result.max = Math.max(v.max, result.max);
    });
    return result;
}

db.Product.mapReduce(map, reduce, {out:{replace:"myResult02"}});
db.myResult02.find();

{ "_id" : "food", "value" : { "Category" : "food", "sum" : 320, "min" : 100, "max" : 220, "count" : 2 } }
{ "_id" : "material", "value" : { "Category" : "material", "sum" : 480, "min" : 80, "max" : 200, "count" : 3 } }
```



---

인덱스 확인(갑자기..?)

```javascript
> db.Product.getIndexes();

[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]

> db.Product.aggregate([
		{$project:{_id:0, Name:1}}, {$match:{Name:"bread"}}
])

{ "Name" : "bread" }

> db.Product.getIndexes(); // 기본 컬렉션의 인덱스를 확인
> db.Product.ensureIndex({Name:1}); // 인덱스 추가설정
{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}

> db.Product.getIndexes();
[
        {
                "v" : 2,
                "key" : {
                        "_id" : 1
                },
                "name" : "_id_"
        },
        {
                "v" : 2,
                "key" : {
                        "Name" : 1
                },
                "name" : "Name_1"
        }
]
```

```javascript
// 추가된 인덱스 필드의 값을 찾아서 실행 결과를 확인
> db.Product.find({Name:"bread"}).explain();

{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "my_score.Product",
                "indexFilterSet" : false,
                "parsedQuery" : {
                        "Name" : {
                                "$eq" : "bread"
                        }
                },
                "queryHash" : "EBFEE4C5",
                "planCacheKey" : "6D446D9E",
                "winningPlan" : {
                        "stage" : "FETCH",
                        "inputStage" : {
                                "stage" : "IXSCAN",
                                "keyPattern" : {
                                        "Name" : 1
                                },
                                "indexName" : "Name_1",
                                "isMultiKey" : false,
                                "multiKeyPaths" : {
                                        "Name" : [ ]
                                },
                                "isUnique" : false,
                                "isSparse" : false,
                                "isPartial" : false,
                                "indexVersion" : 2,
                                "direction" : "forward",
                                "indexBounds" : {
                                        "Name" : [
                                                "[\"bread\", \"bread\"]"
                                        ]
                                }
                        }
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "DESKTOP-TRAVRJA",
                "port" : 27017,
                "version" : "4.4.6",
                "gitVersion" : "72e66213c2c3eab37d9358d5e78ad7f5c1d0d0d7"
        },
        "ok" : 1
}
```

```javascript
// 인덱스 삭제
db.Product.dropIndex({Name:1});

{ "nIndexesWas" : 2, "ok" : 1 }

db.Product.getIndexes();

[ { "v" : 2, "key" : { "_id" : 1 }, "name" : "_id_" } ]

// 이름 순으로 정렬
db.Product.find().sort({Name:1});
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd07"), "Name" : "bread", "Price" : 100, "Category" : "food" }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd03"), "Name" : "notebook", "Price" : 200, "Category" : "material" }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd06"), "Name" : "others", "Price" : 200, "Category" : "material" }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd04"), "Name" : "pencil", "Price" : 80, "Category" : "material" }
{ "_id" : ObjectId("60c8045b08acd45ff3d2fd05"), "Name" : "salad", "Price" : 220, "Category" : "food" }

// bread 찾아서 실행 결과를 확인
db.Product.find({Name:"bread"}).explain();

{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "my_score.Product",
                "indexFilterSet" : false,
                "parsedQuery" : {
                        "Name" : {
                                "$eq" : "bread"
                        }
                },
                "queryHash" : "EBFEE4C5",
                "planCacheKey" : "EBFEE4C5",
                "winningPlan" : {
                        "stage" : "COLLSCAN",
                        "filter" : {
                                "Name" : {
                                        "$eq" : "bread"
                                }
                        },
                        "direction" : "forward"
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "DESKTOP-TRAVRJA",
                "port" : 27017,
                "version" : "4.4.6",
                "gitVersion" : "72e66213c2c3eab37d9358d5e78ad7f5c1d0d0d7"
        },
        "ok" : 1
}
```



---

이분탐색

이름 점수 

홍길동 70

정길동 50

박길동 40

이길동 30

김길동 90

4 0을 점수를 받은학생을 찾아보자?

30 40 50 70 90 내부적으로 일단 정렬 ==> 필기해둔거 보자

몽고는 분산, 샤딩 등을 해야하기 때문에 인덱싱이 필수다



2d indexes / 2d sphere indexes / geoJSON 

Geospatial Queries



---

몽고DB 지리 인덱스 쿼리 구성

- 지리공간 데이터를 저장하는 방법

1. 좌표 : 종래의 좌표를 나타내는 데이터, 주로 평면상의 점을 사용, 표현할 수 있는 도형의 점

   {loc:[10,20]} 점만 사용



2. GeoJSON : 새로운 다양한 형태를 표현할 수 있는 데이터 주로 지구표면의 위도, 경도를 다루는데 사용한다.

   {loc:{type :"Point", coordinates:[10,20]}}  

   //점,선,원 등도 가능, 타입을 선언하고 뒤에 조건은 타입에 따라 달라진다.



쿼리 유형 3가지 (Geospatial Query Operators)

1. 내포된 쿼리 : ($geoWithin) : 다각형 좌표, 사각좌표, 원형좌표

   지구 표면의 원형으로 검색된 쿼리 : (2d / 2dsphere) 모두 사용

2. 겹침 : $geoIntersects / 2dsphere만 사용 / 점, 선, 다각형

3. 근거리 구하기 : $near / ( 2d/2dsphere가능 ) / 점과의 거리, 좌표와 점과의 거리

https://docs.mongodb.com/manual/geospatial-queries/





검색조건

- GeoJSON : 점 $geometry:{type:"Point", 뒤에 매개인자~~}

- GeoJSON : 직선  $geometry:{type:"LineString", 뒤에 매개인자~~}

- GeoJSON : 다각형  $geometry:{type:"Polygon", 뒤에 매개인자~~}

- GeoJSON : GeoJSON 집합  $geometry:{type:"GeometryCollection", 뒤에 매개인자~~}

  https://docs.mongodb.com/manual/reference/geojson/#linestring

  

- 좌표 : 점[x1, y1]
- 좌표 : 사각형 $box
- 좌표 : 다각형 $polygon
- 좌표 : 원형 $center
- 좌표 : 지구 표면의 원형 , $centerSphere

---

37.545018, 127.077025



```javascript
> db.createCollection("location")
{ "ok" : 1 }
> db.location.save({_id:"A", position:[0.001, -0.002]})
> db.location.save({_id:"B", position:[1.0, 1.0]}) 
> db.location.save({_id:"C", position:[0.5, 0.5]})
> db.location.save({_id:"D", position:[-0.5, -0.5]})

> db.location.find()
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
```

```javascript
> db.location.ensureIndex({position:"2d"})

{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}

> db.location.find({position:{$within:{$box:[[0.25, 0.25], [1.0, 1.0]]}}})
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
// 오.. 신기해

> db.location.ensureIndex({position})
> db.location.find({position:{}})

```



현재 나의 위치가 (0,0) 주변의 약국의 동그라미로 찾았더니 A,B,C,D의 위치가 리턴되더라

```javascript
> db.location.find({position:{$within:{$center:[[0,0], 1.42]}}})

{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
{ "_id" : "B", "position" : [ 1, 1 ] }
```



(0,0)에서 ~0.75 사이 거리의 약국을 찾고 싶다.

```javascript
> db.location.find({position:{$near:[0,0], $maxDistance:0.75}}) 
// $maxDistance... 미친놈인가
{ "_id" : "A", "position" : [ 0.001, -0.002 ] }
{ "_id" : "D", "position" : [ -0.5, -0.5 ] }
{ "_id" : "C", "position" : [ 0.5, 0.5 ] }
```

$maxDinstance : For [GeoJSON](https://docs.mongodb.com/manual/reference/glossary/#std-term-GeoJSON) point objects, specify the distance in meters, not radians.

$center랑 $maxDistance차이는 단위차이인듯.













































































