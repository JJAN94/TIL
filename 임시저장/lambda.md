# lambda 함수

람다(lambda)식
 - 1행의 이름없는 익명함수를 만들 수 있다.
 - 함수 객체를 전달할 때 자주 사용
 - 람다식은 한줄(1행)로 표현해야함. (줄바꿈 x)

```python
lambda 인수1, 인수2... : 반환값이 되는 식
```



예시) plus함수를 만들어 보자.

```python
def plus(x, y):
    return x + y

plus(3,4)
>>> 7
```

x, y를 넣었을 때 x + y를 리턴해주는 함수

이를 lambda로 쓰면 같은 함수인데 한줄로 쓸 수 있다.

```python
plus = lambda x, y : x + y

plus(3,4)
>>> 7
```

---

그러면 어떨 때 lambda 식을 쓰면 좋을까?

lambda를 남발하다보면 오히려 코드의 가독성이 떨어진다. 그래서 적절한 상황에 쓰는 것이 좋다.
함수를 인수로 받는 함수를 호출 할 때 쓰면 유용하다.

예시)

```python
ls = ['apple', 'banana', 'orange', 'mango', 'melon']

# 과일 중 글자 수가 6개인 것만 필터링 하자
filtered = filter(lambda x : len(x)==6, ls)
print(filtered)
>>> 'banana', 'orange'
```







