- ROI
  - Region of Interest (관심영역)
  - 영상에서 특정 연산을 수행하고자 하는 임의의 부분 영역
  - 이미지 상의 특정 오브젝트나 특이점을 찾는 것을 목표로 할 때 쓴다.
- Mask Operation
  - OpenCV는 일부 함수에 대해 ROI 연산을 지원하며, 이때 마스크 영상을 인자로 함께 전달해야 한다.
    - ex) cv2.copyTo(), cv2.calcHist(), cv2.bitwise_or(), cv2.matchTemplate(), etc...
  - 마스크 연상은 cv2.CV_8UC1 타입(grayscale)
  - 마스크 영상의 픽셀 값이 0이 아닌 위치에서만 연산이 수행됨
    보통 마스크 영상으로는 0 또는 255로 구성된 이진 영상(binary image)을

