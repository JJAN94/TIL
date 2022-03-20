Sequence Data

- text, speech, financial data, stock



Time Sequence

- 기간으로 나눠진 연속된 데이터
- stock price
- weather



최근 딥러닝을 사용으로 Bag of words 보다는 다양한 알고리즘을 사용한다. (Bert 등을 사용)



Bag of words

단어의 순서를 고려 하지는 않고 일단 단어의 빈도수를 측정함

벡터화 -> 벡터안 단어들이 몇번이 나왔는지를 나타냄

예) feature vector -> 3, 1, 0, 0, 0

| insurance | loan | pickles | backpack | football |
| --------- | ---- | ------- | -------- | -------- |
| 3         | 1    | 0       | 0        | 0        |



다음과 같이 테이블을 만들 수 있다. 그리고 logistic regression, neural network 등과 같은 알고리즘을 적용할 수 있다.

|            | word1 | word2 | ...  | word D | Spam? |
| ---------- | ----- | ----- | ---- | ------ | ----- |
| Document1  | 0     | 1     | ...  | 3      | 0     |
| Document2  | 20    | 0     | ...  | 5      | 1     |
| ...        | ...   | ...   | ...  | ...    | ...   |
| Document N | 0     | 7     | ,,,  | 0      | 1     |

word 가 feature들, spam? 이 class

 





