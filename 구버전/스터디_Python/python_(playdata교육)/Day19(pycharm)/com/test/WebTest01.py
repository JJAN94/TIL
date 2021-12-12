# 레이디버그 게시판 전체의 글을 다 크롤링해서 날짜와 본문내용을 가져오자.
from bs4 import BeautifulSoup
import urllib.request

def Test() :
    list_res01 = []  # 날짜
    list_res02 = []  # 내용

# 1. 웹에서 html 문서를 가져와서 beautifulsoup로 파싱

    for i in range(1,23) :
        list_url = 'https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?c.page='+str(i)+'&hmpMnuId=106&searchCondition=&searchConditionValue=0&searchKeywordValue=0&searchKeyword=&bbsId=10059819&'
        url = urllib.request.Request(list_url)

        result = urllib.request.urlopen(url).read().decode('utf-8')
        soup = BeautifulSoup(result, 'html.parser')

# 2. 게시판의 날짜와 본문의 내용을 가져온다.
        result01 = soup.find_all('span', class_='date')
        result02 = soup.find_all('p', class_='con')

# 3. 게시판의 날짜와 본문을 리스트 객체에 담자.
        for i in result01 :
            list_res01.append(i.get_text(' ', strip=True))
        for j in result02 :
            list_res02.append(j.get_text(' ',strip=True))

# 4. 날짜와 본문을 같이 출력
    for k, h in zip(list_res01,list_res02) :
        print(k + ' '+ h)


def Test02() :
    list_res01 = []  # 날짜
    list_res02 = []  # 내용
    f = open('mytest.txt', 'w', encoding='utf-8')
    # 1. 웹에서 html 문서를 가져와서 beautifulsoup로 파싱

    for i in range(1, 23):
        list_url = 'https://home.ebs.co.kr/ladybug/board/6/10059819/oneBoardList?c.page=' + str(i) + '&hmpMnuId=106&searchCondition=&searchConditionValue=0&searchKeywordValue=0&searchKeyword=&bbsId=10059819&'
        url = urllib.request.Request(list_url)

        result = urllib.request.urlopen(url).read().decode('utf-8')

        soup = BeautifulSoup(result, 'html.parser')

        # 2. 게시판의 날짜와 본문의 내용을 가져온다.
        result01 = soup.find_all('span', class_='date')
        result02 = soup.find_all('p', class_='con')

        # 3. 게시판의 날짜와 본문을 리스트 객체에 담자.
        for i in result01:
            list_res01.append(i.get_text(' ', strip=True))
        for j in result02:
            list_res02.append(j.get_text(' ', strip=True))

    # 4. 날짜와 본문을 같이 출력
    for k, h in zip(list_res01, list_res02):
        f.write(k + ' ' + h+'\n')
    f.close()

if __name__ == '__main__':
    Test()