# Javascript 기초

<img src="C:\Users\JAY\Desktop\TIL\스터디_Javascript\js_front.jpg" alt="js_front" style="zoom:50%;" align='left'/>

---

실습환경 : eclipse / 서버 : Tomcat v9.0 (localhost)

New -> Dynamic Web Project -> src -> main -> webapp -> test1과 js 폴더 만들기

---

## 자바스크립트 태그

- `<script type="스크립트 종류" src=파일명>`
- 파일명에는 경로를 포함흔 파일명을 설정

```html
<script type="text/javascript" src="../js/js01.js"></script>
```

예시

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/js01.js">
</script>
</head>
<body>
<hr>
<script type="text/javascript">
	
	document.write("First script")
</script>
<hr>
<script type="text/javascript" src="../js/js01.js">
</script>
</head>
</body>
</html>
```

- html에 바로 js문을 써도되고 src에 파일을 줘서 불러와도 된다.

```javascript
document.write("First script1<br>");
document.write("First script2<br>");
document.write("First script3<br>");
document.write("First script4<br>");

/* 
1. 오류가 뜨면 js는 아예 실행이 안됨
2. 또한 브라우저에서 에러 사항이 뭔지 알려줌
3. 브라우저에서 수정을 해도 원본 js파일은 변하지 않는다.
4. 브라우저에서 무엇이 잘못되었는지 알려준다. 돌려보고 에러코드를 살펴보자.
*/
```

실행결과

```html
First script1
First script2
First script3
First script4
-------------------------------------------------------
First script 
-------------------------------------------------------
First script1
First script2
First script3
First script4
```

- 처음에 `<script type="text/javascript" src="../js/js01.js">
  </script>` 가 실행되어 위에 4줄이 실행.
- `<hr>`로 라인이 생기고 html에 작성한 `<script type="text/javascript">document.write("First script")</script>` 이 실행됨
- `<hr>`로 라인이 또 생기고 `<script type="text/javascript" src="../js/js01.js"></script>` 가 실행되어 위에 4줄이 실행.



## prompt, alert, confirm, document.write()

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var name = prompt("input name", "NameName");
alert("input name "+name);
document.write("입력한 이름은 : "+ name + "입니다.");
confirm("현재 페이지를 종료할까요?");
document.write(res);


</script>
</body>
</html>

<!-- prompt, alert, confirm -->
```

- **var 변수**
  - 변수를 지정할 때 var 변수명 을 쓴다. 
  - 변수 명명규칙은 파이썬과 동일하다. (한글변수명은 사용 불가)

- **prompt('메시지', 'default value')**
  - 파이썬의 input함수와 동일. 
  - '메시지'는 주고싶은 문장, 'default value'은 기본적으로 들어가는 문장  
- **alert("메시지")**
  - 웹 페이지 메시지를 띄어줌.
  - 확인을 누르기 전까지 꺼지지 않음

- **confirm('메시지')** 
  - 메시지, 웹 페이지 메시지 내용을 띄어줌
  - 확인과 취소버튼이 뜨고 확인을 누르면 true, 취소는 false를 반환한다.
- **document.write("메시지1"+변수+"메시지2"+...)**
  - 파이썬의 print()문과 동일
  - 파이썬과 같이 +연산자로 str을 묶을 수 있다.



## 산술 연산 예시

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var a = prompt("input A");
var b = prompt("input B");
// a = Number(a);
// b = Number(b);

var hap = 0;
hap = eval(a+"+"+b);
document.write("hap = "+hap);

var res = "1+2+3";
document.write("<br>답은"+eval(res));

</script>

</body>
</html>
<!--  외부에서 들어오는 값은 문자열로 취급한다. prompt에서 "0"은 숫자가 아닌 string -->
```

- prompt로 들어오는 값은 str이다.
- 일반적으로(숫자연산) +해주려면 형변환이 필요. 파이썬처럼 str+str처럼 실행되기 때문이다.
- a = "10", b = "20"이라 하고, eval() 함수를 쓴다. 
  - a+"+"+b => "10+20" 처럼 변환이되어 문자열 계산함수로 쓸 수 있다.



## 데이터 형

  - js는 숫자나 문자를 자동으로 인식하기에 데이터형을 선언하지 않는다.
  - 부동소수점 사용 가능. 지수를 쓸 때는 2e5같이 e를 쓰자.
  - 불리언 : true, false를 사용
  - 문자열 : " ", ' ' 으로 묶어서 사용
  - 이스케이프 시퀀스 : \\', \\", \\\, 등 사용 가능 




## 연산자

- 산술 연산자

| 연산자 | 설명             |
| ------ | ---------------- |
| +      | 더하기 연산      |
| -      | 빼기 연산        |
| *      | 곱하기 연산      |
| /      | 나누기 연산      |
| %      | 나머지 값을 반환 |

- 관계 연산자

| 연산자 | 설명        |
| ------ | ----------- |
| ==     | 같다        |
| !=     | 같지 않다   |
| <      | 작다        |
| <=     | 작거나 같다 |
| >      | 크다        |
| >=     | 크거나 같다 |

- 논리 연산자

| 좌변     | 우변     | `||` (or) | && (and) | ^ (xor)  |
| -------- | -------- | --------- | -------- | -------- |
| False(0) | False(0) | False(0)  | False(0) | False(0) |
| False(0) | True(1)  | True(1)   | False(0) | True(1)  |
| True(1)  | False(0) | True(1)   | False(0) | True(1)  |
| True(1)  | True(1)  | True(1)   | True(1)  | False(0) |

- 삼항 연산자
  - 조건을 실행하고 참이면 변수1을 반환, 거짓이면 변수2를 반환

```javascript
(조건)? 변수1 : 변수2
```



## 제어문 - 조건문, 반복문

- if - else if - else 문
- switch - case 문
- for 문
- while 문

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var str = prompt("input 1~4"); //4계절 출력
	document.write("<hr> <h1> If     </h1>");
	
	if (str==1){
		document.write("봄");}
	else if (str==2){
		document.write("여름");}
	else if (str==3){
		document.write("가을");}
	else {
		document.write("겨울");}
	
	
	
	document.write("<hr> <h1><br> switch-case     <br></h1>");
	var str1 = prompt("번호를 입력하세요. 1.봄 2.여름 3.가을 4.겨울")
	switch(Number(str1))
	{
	case 1 : document.writeln("봄");
		break
	case 2 : document.writeln("여름");
		break
	case 3 : document.writeln("가을");
		break
	case 4 : document.writeln("겨울");
		break
	}
//	switch(str1)
//	{
//	case "1" : document.writeln("봄");
//		break
//	case "2" : document.writeln("여름");
//		break
//	case "3" : document.writeln("가을");
//		break
//	case "4" : document.writeln("겨울");
//		break
//	}
		
	document.write("<hr> <h1><br> even-odd     <br></h1>");
	var str2 = prompt("숫자 입력");
	//1,3 홀수, 2,4는 짝수
	switch(str2)
	{
	case "3" : 
	case "1" : document.write("홀수<br>"); break; //break를 주냐안주냐에 따라 뜻이 달라진다. 3을 넣으면 3다음에 1을 실행해 홀수를 출력
	case "4" : 
	case "2" : document.write("짝수<br>"); break; //4를 넣으면 4다음에 2를 만나 짝수를 출력한다.
	default : document.write("다른값이야<br>"); //1,2,3,4가 아닌 다른 값이 입력됬을 때 기본적으로 출력할 문장을 지정해줄 수 있다.
	}
	// switch-case에서 조건은 case "3", "4": -> 이런식으로 나열할 수 없다. 하나만 줘야한다.
		
	document.write("<hr><h1> for <h1>");
	var hap = 0;
	var str3 = prompt('입력숫자')
	for(i =1 ; i<=str3 ;i++){  //for문 형태 기억
		hap += i;
	}
	document.writeln("1~ "+str3+"의 합은 "+hap+"이다. <br>");
	
	
	
	document.write("<hr> <h1><br> while     <br></h1>");
	var str4 = prompt("숫자넣어줘");
	while(str4>0){
		document.write("while 구문이다. <br>");
		str4--;
	};
	
	document.write("<hr> <h1><br> do while     <br></h1>");
	do{
		document.write("do ~ while 구문이다. <br>");
		str4--;
	}while(str4>0);
	
//switch-case문은 break를 안주면 switch-case문 끝까지 계속 순차 실행하기 때문에 break를 적절히 넣어줘야한다.
//break시 즉시 탈출

</script>
</body>
</html>
```



---

### HTML 주석

```html
<!-- 주석 내용 -->
```

JAVASCRIPT 주석

```javascript
한 줄 주석
//single line comment

여러 줄 주석
/* 
multi-line comment 
*/
```

(주의) HTML 문서에 넣은 자바스크립트 주석은 소스보기를 하면 다 보인다. 개발 과정에서 작성했지만 공개되면 안되는 주석들이 있으면 삭제하는 것이 좋다.











