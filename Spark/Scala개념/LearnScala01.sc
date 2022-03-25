// 스칼라 공부 01
// Value : immutable constants

// 불변 상수라 정의
val hello: String = "Hola!"

// Variable : mutable
var helloThere: String = hello // 변수에 리터럴상수를 넣어줌.
helloThere = hello + "There" // 변수는 수정 가능

println(helloThere)

// 스파크에서는 병렬처리를 하는데 이때 var이여서 멀티스레드할 때 변수가 바뀌면...?
// 이를 피하고자 var와 val의 구분이 필요하다.

val immutableHelloThere = hello + " There"
println(immutableHelloThere)

// Data Type

val numberOne: Int = 1
val truth : Boolean = true //true, false 소문자
val letterA : Char = 'a' //single string
val pi : Double = 3.14159265
val piSinglePrecision : Float = 3.14159265f
val bigNumber : Long = 123456789
val smallNumber : Byte = 127

println("Here is a mess : " + numberOne + truth + letterA + pi + bigNumber)

// 스칼라는 명령 뒤에 ; 쓸필요 없음

// f스트링도 지원
println(f"Pi is about $piSinglePrecision%.3f")

println(f"Zero padding on the left: $numberOne%05d")
// 변수를 문자열로 대체하기위해 s를 쓰기도 한다.
println(s"I can use the a prefix to use variables like $numberOne $truth $letterA")

println(s"The a prefix isn't limited to variables; I can include any expression. Like ${1+2}")

// 정규표현식
val theUltimateAnswer: String = "To life, the universe, and everything is 42."
val pattern = """.* ([\d]+).*""".r // .r : 우리가 정의하는 정규식이라는 의미

val pattern(answerString) = theUltimateAnswer
val answer = answerString.toInt
println(answer)

//Boolean
val isGreater = 1 > 2
val isLesser = 1 < 2
val impossible = isGreater & isLesser
val anotherWay = isGreater || isLesser

val picard: String = "Picard"
val bestCaptain: String = "Picard"
val isBset: Boolean = picard == bestCaptain
