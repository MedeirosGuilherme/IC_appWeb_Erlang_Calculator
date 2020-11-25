from flask import render_template
from app import app

@app.route('/')
@app.route('/index')
def index():
    user = {'username': 'Miguel'}
    posts = [
        {
            'author': {'username': 'Guilherme'},
            'body': 'Lindo dia na Enseada!'
        },
        {
            'author': {'username': 'Diego'},
            'body': 'Comprei um fusca novo!'
        },
        {
            'author': {'username': 'Alessandra'},
            'body': 'Eu adorei o último filme do Ari Aster!'
        }
    ]
    return render_template('index.html', title='Home', user=user, posts=posts)
