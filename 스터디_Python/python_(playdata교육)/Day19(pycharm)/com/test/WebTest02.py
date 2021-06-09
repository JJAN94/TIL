# 중앙일보에서 인공지능을 검색후 최근 3개의 상세기사의 url를 스크롤 하자.
# https://news.joins.com/article/24055226
# https://news.joins.com/article/24055193
# https://news.joins.com/article/24055000

from bs4 import BeautifulSoup
import urllib.request


def Test() :
    list_url = 'https://news.joins.com/search/?keyword=%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5'
    url = urllib.request.Request(list_url)
    result = urllib.request.urlopen(url).read().decode('utf-8')

    soup = BeautifulSoup(result, 'html.parser')

    # 상세기사를 가지고 올 수 있게 태그와 클래스를 찾는다.
    result01 = soup.find_all('h2', class_='headline mg')

    ls = []
    for i in result01 :
        for k in i : # h2태그 이너요소인 a태그를 가져오기 위한 코드
            print(k.get('href'))

    # result01의 결과가 리스트, forloop를 이용해서 요소를 꺼내고 href값을 리턴받자.

def Test01() :
    # 상세 기사의 본문 텍스트를 스크롤링해서 출력해보자.
    list_url = 'https://news.joins.com/article/24055226'
    url = urllib.request.Request(list_url)
    result = urllib.request.urlopen(url).read().decode('utf-8')
    soup = BeautifulSoup(result, 'html.parser')

    # 상세기사의 본문을 가져올 수 있도록 태그와 클래스를 찾아보자.
    result1 = soup.find_all('div', class_='article_body mg fs4')
    params2 = []
    for i in result1 :
        params2.append(i.get_text(' ',strip=True))
    print(params2)

def Test02() : # 동아일보도 해보자. 인공지능으로 검색해서 패턴을 잠시 보고 있자.
    pass


if __name__ == '__main__' :
    Test()

