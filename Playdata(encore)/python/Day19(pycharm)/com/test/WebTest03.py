from bs4 import BeautifulSoup
import urllib.request

def d_scroll() : # 동아일보도 해보자.

    # 1. 동아일보도 해보자. 인공지능 검색
    # 2. 상세 기사 url 리스트에 담는 j_scroll()을 만들자.
    # 3. 상세 기사 url로 기사 본문을 스크롤링 하는 j_detail_scroll()을 만드자.
    # 4. j_detail_scroll()함수에서 j_scroll()을 호출한 후 상세기사 url 받아서 본문 기사 params에 담자.
    list_url = 'https://www.donga.com/news/search?p=1&query=%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5&check_news=1&more=1&sorting=1&search_date=1&v1=&v2=&range=1'
    url = urllib.request.Request(list_url)
    result = urllib.request.urlopen(url).read().decode('utf-8')
    soup = BeautifulSoup(result, 'html.parser')

    result1 = soup.find_all('p', class_='txt')
    params = []
    for i in result1 :
        for k in i :
            params.append(k.get("href"))

    return params

def j_detail_scroll() :
    list_url = d_scroll()
    params2 = []
    for i in list_url :
        url = urllib.request.Request(i)
        result = urllib.request.urlopen(url).read().decode('utf-8')
        soup = BeautifulSoup(result, 'html.parser')
        # 상세 기사의 본문을 가져오는 태그와 클래스를 찾자.
        result1 = soup.find_all('div', class_="article_txt")

        # 위의 내용을 for lopp
        for i in result1 :
            params2.append(i.get_text(" ", strip=True))

    return params2

print(j_detail_scroll())

# 모듈임포트 -> 수집 -> list 에 append -> 통계분석 -> 출력
# 1. 웹스크롤링 기술 -> 2. 통계로 데이터 분석 -> 3. 머신러닝으로 데이터 분석 -> 4. 딥러닝으로 데이터 분석
