from flask import Flask, request

app = Flask(__name__)


def do_the_login():
    return "do the login"
def show_the_login_form():
    return 'show the login form'

@app.route('/login', methods=['GET', 'POST'])
# Post 메서드로 url 접속하면 do_the_login() 함수가 실행
# Get으로 접속하면 show_the_login_form() 이 실행
def login():
    if request.method == 'POST':
        return do_the_login()
    else:
        return show_the_login_form()

if __name__ == '__main__':
    app.run()


# Get?
# 클라이언트에서 서버로 어떠한 리소스로부터 정보를 요청하기 위해 사용되는 메서드
# 예로 게시판의 게시물을 조회할 떄 쓸 수 있다.
# URL 끝에 ?를 붙이고 변수명1=값1&변수명2=값2...형식으로 붙는다.

# Post?
# 클라이언트에서 서버로 리소스를 생성하거나 업데이트하기 위해 데이터를 보낼 때 사용하는 메서드
# 게시판의 게시글을 작성하는 작업 등을 할 때 사용