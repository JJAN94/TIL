from flask import Flask
'''
플라스크 애플리케이션을 생성하는 코드.
__name__이라는 변수에는 모듈명이 담긴다.
즉, 이 파일이 실행되면 pybo.py라는 모듈이 실행되는 것이므로 __name__변수에 'pybo'라는 문자열이 담긴다.
'''
app = Flask(__name__)

# 특정 주소에 접속하면 바로 다음 줄에 있는 함수를 호출하는 데코레이터
@app.route('/')
def hello_pybo():
    return 'Hello, Pybo!'
