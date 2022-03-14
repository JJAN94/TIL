# TensorRT

## 1. TensorRT란?

> 작성일 기준 버전 : December 14, 2021

TensorRT는 고성능 inference를 가능하게 하기 위해  훈련된 딥러닝 모델을 최적화 해주는 SDK다.

즉, 딥러닝 인퍼런싱 최적화 라이브러리다.



>  SDK란?
>
> 소프트웨어 개발 키드(Software Development Kit, SDK)는 하드웨어 플랫폼, 운영체제 또는 프로그래밍 언어 제작사가 제공하는 일련의 툴

>deep learning inference?
>
>학습을 통해 만들어진 모델을 실제로 새로운 입력 데이터에 적용하여 결과를 내놓는 단계



TensorRT에는 훈련된 딥러닝 모델을 위한 딥러닝 inference optimizer와 실행을 위한 런타임이 포함되어 있다.

일단 tensorflow, pytorch 등의 프레임워크에서 모델을 학습 후, TensorRT를 사용하면 처리량(throughput)을 높이고 latency를 줄일 수 있다.



![dl-cycle](.\dl-cycle.png)



## 2. TensorRT Ecosystem



















## Low-precision training

NVIDIA V100 장비는 32비트의 부동 소수점에선 14 테라플롭스의 성능을 제공하지만 16비트의 부동 소수점 연산을 사용하면 100 테라플롭스의 성능까지 사용할 수 있다. 그래서 딥러닝 학습을 할 때 부동소수점을 32비트에서 16비트로 변환하고 가중치 값이 유실되는 것을 방지하기 위해 스칼라 값을 곱해서 사용하면 학습할 때 2–3배 정도 성능을 높일 수 있다고 한다.



