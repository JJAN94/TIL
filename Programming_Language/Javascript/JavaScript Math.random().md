JavaScript Math.random()



자바스크립트 Math.random() 은 0~1 사이의 난수를 무작위로 반환한다.

`*` 곱하기, `+`더하기 기호로 최대, 최소 범위 지정이 가능하다.

정수만을 출력하기 위해서는 Math.floor() 객체를 같이 사용하면 된다.



```javascript
document.write(Math.random());
```

```python
print(random.randn)
```



0~원하는 최대값 지정

```javascript
/* 만약 원하는 최대값이 10이라면? */
Math.random() * 10
```



최소값 지정

( **Math**.random () * (최대값 **-** 최소값) ) + 최소값

평행이동이란 개념으로 생각하면 간단하다.
