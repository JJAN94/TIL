# 라우팅

## Flask 객체를 임포트 한다. 이f 클래스의 인스턴스는 WSGI 애플리케이션을 만들어 준다.
from flask import Flask

## Flask 객체의 인자로 __name__이 들어간다. 해당 인자는 정적 파일과 템플릿을 찾는 데 쓰인다.
app = Flask(__name__)

## route 데코리이션을 사용해 URL을 생성한다.
@app.route('/index')
@app.route('/')

def hello_world():
    return 'Hello, World!'

if __name__ == '__main__':
    app.run()
# (method) run: (host=None, port=None, debug=None, load_dotenv=True, **options) -> Any
