from bs4 import BeautifulSoup
import urllib.request
from selenium.webdriver.common.keys import Keys
from selenium import webdriver
import  time #중간중간에 sleep를 걸어야함

def Test():
    binary  = 'c:\chromedriver\chromedriver.exe'
    #브라우저를 인스턴스화 하자.
    browser  = webdriver.Chrome(binary)
    #<div class="pR49Ae gsfi" jsname="vdLsw"></div>
    #input 검색창에 키워드를 입력해서 이미지를 받아오자.
    browser.get("https://www.google.com/imghp?tbm=isch&tab=wi&ei=l1AdWbegOcra8QXvtr-4Cw&sclient=img&ved=0ahUKEwjvxonUvMPwAhWRZd4KHd7aAQUQ4dUDCAc&uac")
    elem =browser.find_element_by_class_name('gLFyf.gsfi')  #class
    #elem  = browser.find_element_by_xpath("//*[@class='gLFyf gsfi']")
    #키워드 검색어 입력
    elem .send_keys("사과") #스크롤링 하고 싶은 검색어
    #엔터를  실행하자
    elem.submit()
    #스크롤을 내리려면 브라우저 이미지 검색결과 부분(바디) 마우스를 클릭한번 하고 End키를 눌러야 한다.
    for  i  in range(1,2): # 2번 스크롤 내려가는 상태
        browser.find_element_by_xpath("//body").send_keys(Keys.END)
        time.sleep(10) # END 키 누르고 내려가는데 시간이 걸려서 sleep 해줌, 키보드를 end키를 총 5누르는데  Eng1번누르고 10초 쉰다
    time.sleep(10) #네트워크 느릴까봐 안정성을 위해 slee 해줌
    html  = browser.page_source #소스 코드를 리턴받는다.
    soup =BeautifulSoup(html,"lxml")  # pip install lxml
    # 그림파일 저장
    #print(soup.find_all("img",class_="rg_i Q4LuWd")) #구글의 이미지 태그
    return soup
#이미지의 상세 url가져오는 함수
def fetch_list_url():
    params  =[]
    soup=Test()
    imgList =  soup.find_all("img",class_="rg_i Q4LuWd")
    for im  in imgList:
        try:
            params.append(im["src"])
        except KeyError:
            params.append(im["data-src"])
    return params
# 파일 저장 하는 코드를 만들자
def fetch_detail_url():
    parmas = fetch_list_url()
    for  idx,p in enumerate(parmas,1):
        #다운 받을 폴더 경로 입력
        urllib.request.urlretrieve(p,"c:/image/"+ str(idx) +"_google.jpg")
if __name__ == '__main__':
    fetch_detail_url()