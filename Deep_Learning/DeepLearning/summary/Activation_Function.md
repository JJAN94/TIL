 # Activation 함수

Activation Function(활성함수)

- 어떤 신호를 입력받아 이를 적절히 처리해 출력해주는 함수



### 시그모이드(sigmoid) 함수

- MLP(Multi Layer Perceptron), Binary Classification에서 사용되는 활성 함수
- DNN에서 쓸 경우 층이 깊어지면 Back Propagation 시 기울기 값이 앞단으로 이동할 수록 0으로 수렴하는 현상이 발생하게 된다. 시그모이드 값 범위가 0~1사이기에 곱하면 곱할 수록 값이 점점 작아지기 때문이다.
- Hidden Layer가 많아질수록 이 함수를 쓰면 안된다.
- $ sigmoid(x) = frac{1}{1 + exp(-x)} $



### ReLU (Rectified Linear Unit)

- 기존 시그모이드의 문제점을 보완해주는 활성 함수

- $ f(x) = max(0, x) $의 함수

- 미분값이 0 또는 1이기에 Back Propagation 과정 중 곱해지는 값은 아예 없어지거나 그대로인 케이스

- 이를 토대로 변형된 함수가 많다. SERLU, SELU, ELU, Leaky ReLU 등등

- 모든 상황에서 ReLU 함수가 좋은 것은 아니다. 상황에 맞는 활성함수를 쓰는게 중요하다.

  