from PROJECT.naver_img_scrapping01 import img_or_txt
from wordcloud import WordCloud #깔리지 않을때는 cmd에서 특정 디렉토리에 whl저장후 '확장자 명 포함'해서 pip install 해줍니다.
import matplotlib.pyplot as plt
from collections import Counter
import numpy as np
from PIL import Image #벡터 변환된 거를 픽셀값으로 변환, 이미지시켜주는 모듈


def put_text(search):

    img_or_txt(search)
    try:
        with open(f'{search}.txt','r',encoding='utf-8') as f:
            a = Counter(f.read().split())
            b = a.most_common(99)
            c = [i for i in b if search not in i[0] and (i[0].isalpha() == True or i[0].isascii() ==False)] #

        image = Image.open('background03.jpg') #이미지 불러오기
        mask =np.array(image) #행렬

        font_path='C:\\Windows\\Fonts\\NGULIM.TTF' #폰트 지정

        wc = WordCloud(font_path, background_color='white',width=mask.shape[1],height=mask.shape[0],max_words=300,max_font_size=300,mask=mask) #그림 크기

        plt.figure(figsize=(10,10)) #캔버스크기,

        #cloud = wc.generate_from_frequencies(dict(c))
        #plt.imshow(cloud, interpolation='bilinear')

        plt.imshow(wc.generate_from_frequencies(dict(c)),interpolation='bilinear') #이미지 띄어주는 것
        plt.axis("off") #축을 없앤다
        plt.show() #창을 띄어주는 것
    except FileNotFoundError as F:
        print("이미지가 성공적으로 파일에 저장되었습니다.")

if __name__ == '__main__':
    put_text(input('검색할 내용은 : '))
