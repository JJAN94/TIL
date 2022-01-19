# 플라스크는 템플릿 엔진으로 Jinja2를 사용함.

from flask import Flask
from flask.templating import render_template

app = Flask(__name__, static_folder='static', template_folder='template')

@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)

if __name__ == '__main__':
    app.run()