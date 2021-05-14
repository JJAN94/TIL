from bs4 import BeautifulSoup
from selenium.webdriver.common.keys import Keys
from selenium import webdriver
import urllib.request
import datetime
import time



'''
def get_where_img(webbrowser):
    raw_url = webbrowser.current_url
    url_rec = urllib.request.Request(raw_url)
    open_url = urllib.request.urlopen(url_rec).read().decode('utf-8')
    soup = BeautifulSoup(open_url, 'html.parser')

    line = soup.find_all('a', class_='tab')
    for i in range(len(line)):
        if '이미지' in line[i]:
            return i + 1
'''


class InvalidValue(Exception):
    def __init__(self,string):
        self.string = string
    def __str__(self):
        return self.string


def get_range():
    now = datetime.datetime.now() #현재 시간 기준으로 추천할 것임.


    while 1:
        #문제가 되는 것 1) 날짜 형식이 맞지 않은 경우, 2)기간 구분자를 너무 많이 쓴 경우, 3)년,월,일 구분을 다른 문자를 사용해서 넣는 경우, 4)그냥 엔터친 경우   -> 잡는다
        try :
            my_input = list(input(f'검색할 기간을 설정해주세요(예: {now.year}-{now.month}-{now.day}~{now.year}-{now.month}-{now.day}) : ').split('~'))   #두개로 나눠져야.
            if len(my_input) !=2:  #두개가 아니면 -> 구분 똑바로해
                raise InvalidValue("기간 구분을 제대로 해주세요")
            from_check = list(filter(lambda x: x.isnumeric() == False, my_input[0])) #check list -> from_에서 숫자가 아닌 경우를 걸러줌
            to_check = list(filter(lambda x: x.isnumeric() == False, my_input[1])) #check list   -> to_에서 숫자가 아닌 경우를 걸러줌
            if from_check.count('-') != 2 or len(from_check) !=2:
                raise InvalidValue("년-월-일 구분자는 (-)을 사용해주세요.")   #사용자 지정 exception을 만들어 인풋값을 입력함으로, 특정 에러 발생시 원하는 아웃풋을 얻는다.
            if to_check.count('-') != 2 or len(to_check) !=2:
                raise InvalidValue("년-월-일 구분자는 (-)을 사용해주세요.")
            y1,m1,d1 = map(lambda x: '0' + x if len(x) == 1 else x,my_input[0].split('-'))
            y2, m2, d2 = map(lambda x: '0' + x if len(x) == 1 else x,my_input[1].split('-'))
            if (int(y1) not in range(1990,2022)) or (int(m1) not in range(1,13)) or (int(d1) not in range(1,32)):
                raise InvalidValue("검색할 수 없는 기간을 선택하셨습니다.")
            if (int(y2) not in range(1990,2022)) or (int(m2) not in range(1,13)) or (int(d2) not in range(1,32)):
                raise InvalidValue("검색할 수 없는 기간을 선택하셨습니다.")
            if '-'.join((y1,m1,d1)) > str(now)[:10] or '-'.join((y2,m2,d2)) > str(now)[:10] :
                raise InvalidValue("나는 미래를 예측할 순 없어요")
            from_ =(y1,m1,d1)
            to_ = (y2,m2,d2)
            # finally,
            # 1)문제 없으면 검색 시작시점을 from_ 변수에 넣어준다.
            # 2) 마찬가지로 to_에는 종료시점을 넣어준다.

        except ValueError as e:
            print("기간 구분은 (~)을 사용해 주세요")
        except InvalidValue as i:
            print(i)
        else:
            break
    return from_,to_


def navigate_url(search): # get_range()[0],get_range()[1]
    range_ = get_range()
    y1, m1, d1 = range_[0]
    y2, m2, d2 = range_[1]

    binary = "C:\chromedriver_win32\chromedriver.exe" #<< 구글 가동
    webbrowser = webdriver.Chrome(binary)
    webbrowser.get("https://www.naver.com/") #시작 페이지  #저희는 정말 '시작부터' 했슴

    mouse = webbrowser.find_element_by_class_name("input_text") #<<마우스 갖다 댐
    mouse.send_keys(search)
    mouse.submit()

    #get the current url
    #print(webbrowser.current_url) #this's enabling us to tell where we are right now.


    webbrowser.find_element_by_link_text('이미지').click() #지정한 텍스트가 있는 곳을 클릭한다.
    time.sleep(3) #화면 넘어가주는 겸 쉬어주고
    webbrowser.find_element_by_xpath('//*[@id="snb"]/div[1]/div/div[3]/a').click()#옵션 -> 직접입력
    webbrowser.find_element_by_xpath('//*[@id="snb"]/div[2]/ul/li[2]/div/div[1]/a[8]').click()#직접입력 -> 펼치기
    time.sleep(1)
    #from
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[1]/div/div/div/ul/li[{eval(y1)-1989}]').click() #1990년 =1  2021 -1990
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[2]/div/div/div/ul/li[{m1}]').click() #4월 1~12
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[3]/div/div/div/ul/li[{d1}]/a').click() #11일
    time.sleep(2)
    #to
    webbrowser.find_element_by_xpath('//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[1]/span[3]/a').click() #가고싶은 월 정하기 전
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[1]/div/div/div/ul/li[{eval(y2)-1989}]').click()  # 2009년
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[2]/div/div/div/ul/li[{m2}]').click()  # 7월 1~12
    webbrowser.find_element_by_xpath(f'//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[2]/div[3]/div/div/div/ul/li[{d2}]/a').click()  # 25일
    time.sleep(2)
    #선택
    webbrowser.find_element_by_xpath('//*[@id="snb"]/div[2]/ul/li[2]/div/div[2]/div[3]/button').click() #이동!
    time.sleep(1)


    #extraction!
    for i in range(5):
        webbrowser.find_element_by_xpath("//body").send_keys(Keys.END) #드래그를 내리겠다.
        time.sleep(1)
    time.sleep(3)
    source = webbrowser.page_source #소스페이지 얻기 Ctrl + U
    soup = BeautifulSoup(source,'lxml') #파싱한다.
    # #'lxml' <-when things get less organized
    # #html.parser
    # #html5lib   < - Extremely lenient, Parses pages the same way a web browser does, Creates valid HTML5
    return soup


def html_img(search):
    soup = navigate_url(search) #해당 페이지 소스를 저장
    list_img = soup.find_all('img') #그러나 img 태그 안에는 링크도있고, 텍스트도 있고 'src'가 있는데도 링크가 없는 것도 있고.
    images = [ i.get("src") for i in list_img if "http" in i.get("src")]   #2 img.   #src중에서 http가 있어서 링크 연결할 수 있는 놈만 뺀다.
    txt = [i.get("alt") for i in list_img if search in i.get('alt')]  # 2alt         # alt 이용해 텍스트 분리시키겠다.
    return images,txt #분류 끝


def img_or_txt(search):
    while 1:
        try :
            search_type = input("1.이미지 / 2.텍스트 - 어떤 검색결과를 얻고 싶으세요? 숫자를 입력해 주세요(1 or 2) : ")
            if search_type not in ('1','2'):
                raise InvalidValue("1 또는 2를 넣어 주세요 : ")
        except InvalidValue as i:
            print(i)
        else:
            break
    images, txt = html_img(search)
    if search_type == '1':
        print("해당 기간에 검색된 이미지는 :",str(len(images))+'개 입니다.')
        for index, file in enumerate(images, 1):
            urllib.request.urlretrieve(file, 'c:/T1/' + str(index) + f'_{search}.jpg') #url로 표시된 네트워크 객체를 로컬 파일로 복사.
    else:
        print("해당 이미지 관련 텍스트의 갯수는 다음과 같습니다 :",len(txt))
        print("이하는 관련 텍스트의 상세 내용입니다.")
        print()
        for i in txt:
            print(i)
        with open(f'{search}.txt','w',encoding='utf-8') as f:
            f.writelines(txt)

if __name__ == '__main__':
    search = input('검색할 내용은 : ')
    img_or_txt(search)

