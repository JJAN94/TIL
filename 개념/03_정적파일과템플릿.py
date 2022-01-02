from flask import Flask, render_template

app = Flask(__name__, static_folder='static', template_folder='template')

@app.route('/hello')
def hello():
    return render_template('hello.html')

if __name__ == '__main__':
    app.run()