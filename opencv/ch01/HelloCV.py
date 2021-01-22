import cv2 
import sys

print('Hello, OpenCV', cv2.__version__)

img = cv2.imread('cat.bmp') # cat.bmp 파일을 불러와 img 변수에 저장

if img is None : # 만약 파일이 없을때 예외처리
    print('Image load failed') # 영상 파일 불러오기가 실패하면 에러 메시지를 출력하고 종료
    sys.exit()

cv2.namedWindow('image') # OpenCv에서 지원하는 image 라는 이름의 새 창을 만듦
cv2.imshow('image', img) # 이 창에 img 영상을 출력함
cv2.waitKey() # 키보드 입력이 있을 때까지 대기

cv2.destroyAllWindows() # 생성된 모든 창을 닫음 