# Pretrained Model and Transfer Learning

미리 잘 만들어둔 좋은 모델을 가져와 우리 환경에 맞게 조정해서 사용

기존 모델 feature extractor의 기반 weight를 가져와서 내 모델의 classification에 이용

Keras Applications에서 사용 가능한 Pretrained 모델은 대부분 ImageNet데이터 셋으로 사전 훈련된 모델

ImageNet은 1000개의 class들에 대한 이미지 분류

최종 Classification Layer가 1000개의 unit의 softmax 형태로 되어 있음

입력 이미지는 개별 pretrained 모델 별로 다를 수 있음(대부분 224 x 224)



```python
model = VGG16(include_top=True, weights='imagenet')
model.summary()
```

include_top : flatten에서 fc layer를 포함할지 안할지(classification layer)

weights : 'imagenet'에서 쓴 weight를 받아서 쓸지 안 쓸지



```python
model = VGG16(input_shape=(32,32,3), include_top=False, weights='imagenet')
model.summary()
```

보통 False



