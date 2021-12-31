참조 : 연결대상의 시작주소를 이용해서 값을 CRUD 하는 것

식별자란?

- 프로그래밍 언어에서 변수(객체 변수), 함수, 메소드, 클래스, 모듈등을 구분하기 위해서 붙이는 이름을 말한다.

식별자의 특징

- 어떤 대상을 유일하게 구별하는 이름 a=100, b=20
- 파이썬의 식별자는 유니코드(unicode) 형식을 취한다.
- 코드에 존재하는 변수, 자료형, 서브루틴 등을 가르키는 토큰이다.
- 프로그램 정보를 처리하기 위해서는 그 정보를 가르키는 방법으로 사용된다.

규칙

- 영문자 A~Z, a~z 또는 _로 시작한다.
- @, $, % 등 문장 부호는 사용하지 않는다.
- 대소문자 구분한다
- 클래스명은 시작하는 대문자를 제외하고 모두 소문자이다. class Test():
- _ : private
- __ : strong private
- ~ __ 로 끝나는 식별자 언어에 의해 정의된 특별한 이름을 의미한다.
  ex) '\_\_name\_\_' 
- 키워드를 제외하고 이름을 명명한다.



키워드 : 프로그램에서 예약된 단어, 파이썬에서 미리 사용하기 위해 예약해둔 단어들

```python
help()
"keywords"
```

```
>>
Here is a list of the Python keywords.  Enter any keyword to get more help.

False               break               for                 not
None                class               from                or
True                continue            global              pass
__peg_parser__      def                 if                  raise
and                 del                 import              return
as                  elif                in                  try
assert              else                is                  while
async               except              lambda              with
await               finally             nonlocal            yield
```

keyword라는 모듈을 확인하는 방법 2가지

1. help() -> "keywords"
2. import keyword (keywords.py 를 불러옴)
   - Lib 폴더에 있는 모듈은 import로 불러올 수 있다.

```python
import keyword
dir(keyword)
```
```
['__all__', '__builtins__', '__cached__', '__doc__', '__file__', '__loader__', '__name__', '__package__', '__spec__', 'iskeyword', 'issoftkeyword', 'kwlist', 'softkwlist']
```
여기서 .연산자로 참조
```python
keyword.kwlist
```

```
['False', 'None', 'True', '__peg_parser__', 'and', 'as', 'assert', 'async', 'await', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']
```

C:\Users\Jay\AppData\Local\Programs\Python\Python38\Lib



del 명령어 : 객체를 메모리에서 삭제하는 명령어

---

변수란? 변하는 수라는 뜻을 가지며 값을 저장할 수 있는 메모리상의 공간을 의미한다.

변수의 특징

1. 숫자값, 문자열 값 또는 클래스의 객체를 나타낸다.
2. 변수에 저장되는 값, 즉 리터럴 상수는 변경할 수 있지만 변수 이름은 그대로 유지된다.
3. 데이터 형식은 응용프로그램이 실행 될 때 값을 저장하기 위해 할당 해야 하는 정확한 메모리 양을 지정한다.
4. 명명은 키워드의 규칙을 따른다.
5. type() 함수를 이용해서 리터럴 자료형 타입을 확인 할 수 있다.
6. 이름을 호출하면 값을 리턴한다.



---

리터럴

<class 'int'> : 정수

<class 'float'> : 실수

<class 'str'> : 문자열

<lass 'bool'> : 불

<class 'NoneType'> : None

**리터럴**이란, 컴파일시 프로그램 내에 정의되어 있는 그대로 정확히 해석되어야 할 값을 의미한다. 이에 비해, 변수란 프로그램의 실행 중에 상황에 따라 다른 값들을 표현할 수 있으며, 상수는 프로그램 실행 중 늘 같은 값을 표현한다. 그러나 리터럴은 명칭이 아니라, 값 그 자체이다. 

예를 들어 아래의 수식에서 "*x*"는 변수이며 "7"은 리터럴이다. $x = 7$ 

리터럴은 숫자 뿐 아니라, 문자 또는 문자열일 수 있다.









































