from bs4 import BeautifulSoup
import urllib.request

# 1. EBS 레이디 버그 시청자 게시판을 가지고 직접 크롤링 해보자.

def Test() :
    list_url = 'https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?hmpMnuId=106'
    url = urllib.request.Request(list_url)

    result = urllib.request.urlopen(url).read().decode('utf-8')
    # print(result)

    soup = BeautifulSoup(result, 'html.parser')
    result02 = soup.find_all('p', class_ = 'con')
    params = []
    for i in result02:
        params.append(i.get_text(" ",strip=True))
    print(params)

def Test02() :
    list_url = 'https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?hmpMnuId=106'
    url = urllib.request.Request(list_url)

    result = urllib.request.urlopen(url).read().decode('utf-8')


    soup = BeautifulSoup(result, 'html.parser')
    result02 = soup.find_all('p', class_ = 'con')
    result03 = soup.find_all('span', class_ = 'date')
    params1 = []
    params2 = []
    for i in result03 :
        params1.append(i.get_text(" ", strip=True))

    for j in result02 :
        params2.append(j.get_text(" ", strip=True))

    for k, h in zip(params1, params2) :
        print(k + ' ' + h)


if __name__ == '__main__':
    Test02()