from bs4 import BeautifulSoup

import urllib.request # 웹상의 url을 파이썬이 인식할 수 있도록 해주는 모듈

def Test() :
    list_url ='http://localhost:8080/WebTest/a.html'
    url = urllib.request.Request(list_url) # 사람이 알아볼수 있는 위의 url을 파이썬이 알아 볼 수 있도록 해주는 첫번째 작업
    print(url, type(url))

    # url를 읽어서 리턴
    result = urllib.request.urlopen(url).read().decode("euc-kr")
    print(result)


def Test02() :
    list_url ='http://www.daum.net'
    url = urllib.request.Request(list_url) # 사람이 알아볼수 있는 위의 url을 파이썬이 알아 볼 수 있도록 해주는 첫번째 작업
    print(url, type(url))

    # url를 읽어서 리턴
    result = urllib.request.urlopen(url).read().decode("utf-8")
    print(result)

def Test03() :
    list_url ='http://localhost:8080/WebTest/a.html'
    url = urllib.request.Request(list_url) # 사람이 알아볼수 있는 위의 url을 파이썬이 알아 볼 수 있도록 해주는 첫번째 작업
    # print(url, type(url))

    # url를 읽어서 리턴
    result = urllib.request.urlopen(url).read().decode("euc-kr")
    # print(result, type(result))
    soup = BeautifulSoup(result, 'html.parser')
    print(soup.h1.get_text())

if __name__ == '__main__':
    Test03()