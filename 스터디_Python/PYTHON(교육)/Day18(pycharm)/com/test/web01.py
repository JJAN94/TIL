from bs4 import BeautifulSoup

def Test() :
    f = open('ecological.html')
    soup = BeautifulSoup(f,'html.parser')
    print(soup, type(soup))

def Test02() :
    # 문서를 파싱해서 class 이름 name 에 접근해서 데이터를 긁어 오시오.
    f = open('ecological.html')
    soup = BeautifulSoup(f, 'html.parser')
    result = soup.find_all(class_ = 'name')
    print(result)

def Test03() :
    # 문서를 파싱해서 class 이름 name 에 접근해서 데이터를 긁어 오시오.
    # 단, text 만 긁어오시오.
    f = open('ecological.html')
    soup = BeautifulSoup(f, 'html.parser')
    result = soup.find_all(class_ = 'name')
    for i in result : # 리스트 객체 안에 요소의 텍스트를 리턴받는다. get_text()
        print(i.get_text())

def Test04() :
    # 문서를 파싱해서 class 이름 number에 접근해서 데이터를 긁어 오시오. 단 숫자만 긁어오시오.
    f = open('ecological.html')
    soup = BeautifulSoup(f, 'html.parser')
    result = soup.find_all(class_ ='number')
    for i in result :
        print(i.get_text())

def Test05() : # Test04에서 긁어온 숫자를 a라고 하는 리스트 객체에 저장한 후 a안의 요소들을 정렬하고 출력
    a = []
    f = open('ecological.html')
    soup = BeautifulSoup(f, 'html.parser')
    result = soup.find_all(class_='number')
    for i in result:
        a.append(int(i.get_text()))
    a.sort()
    print(a)


if __name__ == '__main__':
    Test05()
