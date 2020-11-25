# Curso de Desenvolvimento de Aplicação Web em Python produzido por Miguel Grinberg.

[Site do Curso](https://blog.miguelgrinberg.com/post/the-flask-mega-tutorial-part-i-hello-world)

## Aula1: Instalando e criando primeira aplicação:

A aplicação utiliza o pacote FLASK do python3.
****
**Preparando as ferramentas:**

Foi criado um diretório, dentro foi criado um ambiente virtual:

> $ python3 -m venv venv

O comando cria um diretório venv onde um ambiente virtual pode ser criado. O ambiente virtual é ativado usando o comando:

> $ source venv/bin/activate

> (venv) $ -

O terminal passa a executar os comandos pelo ambiente virtual.
Todo esse sistema foi criado para garantir o funcionamento do Flask na versão atual intacta.

Neste momento o Flask pode ser instalado dentro do ambiente virtual, como se instala qualquer outro pacote em python:

> $ (venv) $ pip install flask
****
**A primeira aplicação: Hello World**

Foi criado um diretório onde a aplicação vai rodar, no mesmo diretório microblog onde o diretório *venv* existe, que roda o ambiente virtual.

> (venv) $ mkdir app


Dentro dele foram criados arquivos .py que rodam coisas diferentes. O primeiro, nomeado __ init __.py inicia a aplicação.

*microblog/app/__ init __.py* :
```python
from flask import Flask

app = Flask(__name__)

from app import routes
```
O segundo, routes.py, dá as diferentes URL que a aplicação implementa.

*microblog/app/routes.py* :
```python
from app import app

@app.route('/')
@app.route('/index')
def index():
    return "Hellow, World!"
```
Para completar esta primeira aplicação, é criado na raiz do diretório do projeto (nesse caso a paste microblog) uma execução em python que chama a aplicação

*microblog/microblog.py*
```python:
from app import app
```

Aqui é dito ao Flask o que ele deve rodar:
> (venv) $ FLASK_APP=microblog.py

E a aplicação pode ser executada fazendo:

> (venv) $ flask run

> * Serving Flask app "microblog"

> * Running on http://127.0.0.1:5000

Que pode ser finalizada apertando CTRL+C

A aplicação web pode ser acessada no endereço que vem como resposta do flask run, 127.0.0.1:5000. 127.0.0.1 pode ser encurtado por localhost, fazendo com que a aplicação possa ser verificada em http://localhost:5000

A imagem do site em execução pode ser visto na figura 1.

![figura1](modelo1.png)
`Figura 1: Modelo inicial do website em execução no localhost`

Para encurtar futuras execuções, o comando ao flask pode ser resumido criando um arquivo .flaskenv na raíz do diretório contendo:

```bash 
FLASK_APP=microblog.py
```

Para isso funcionar, antes deve ser instalado o pacote dotenv com o comando:

> (venv) $ pip install python-dotenv

****

## Aula 2: Continuando a implementação do site modelo e aprendendo a usar templates (entre outras ferramentas)

Neste capítulo, o curso introduz o conceito de templates, adentra em ferramentas HTML e faz a utilização destes modelos no upgrade do website inicial.

O primeiro upgrade é modificar o retorno do código que implementa a saída expressa na página criada, utilizando HTML. A documentação html de apoio pode ser encontrada em:

[HTML Markup](https://en.wikipedia.org/wiki/HTML#Markup)

A modificação ficou:

*app/routes.py* :
```python
from app import app
@app.route('/')
@app.route('/index')
def index():
    user = {'username':'Guilherme'}
    return '''
<html>
    <head>
        <title> Home Page - Microblog </title>
    </head>
    <body>
        <h1> Hello, ''' + user['username'] + '''!</h1>
    </body>
</html>'''
```

O resultado da modificação pode ser visto na figura 2.

![figura2](modelo2.png)
`Figura 2: Segundo modelo do site, pós modificação e inserção de código HTML`

****
**Templates:**

Aqui é introduzido o conceito de templates pela dificuldade de modificar o código quanto este se torna longo demais, adicionando um novo diretório:

> (venv) $ mkdir app/templates

Neste diretório o template em HTML será colocado e este será utilizado e modificado o quanto for preciso. O curso ensina a utilizar o template logo depois.

O código html é inserido em /app/templates/index.html e segue como:

*/app/templates/index.html* :
```html
<html>
    <head>
        <title>{{title}} - Microblog</title>
    </head>
    <body>
        <h1>Hello, {{ user.username }}!</h1>
    </body>
</html>
```

E a utilização do template no código em python fica:

*/app/routes.py* :

```python
from flask import render_template
from app import app

@app.route('/')
@app.route('/index')
def index():
    user = {'username':'Guilherme'}
    return render_template('index.html', title='Home', user=user)

```

Todo esse funcionamento acontece usando o *render_template* do framework do Flask, função que implementa um template em uma página HTML completa considerando as variáveis abertas.

O *render_template*, na realidade, faz mais do que isso, invocando a engina [Jinja2](https://jinja.palletsprojects.com/en/2.11.x/) que substitui qualquer entrada do tipo {...} pelas variáveis passadas pela chamada do *render_template*.

****

**Condicionais em Jinja2:**

Há operações que podem ser feitas utilizando o Jinja2, dentre elas, condicionais podem ser realizadas dentro do template utilizando a tag **{%`<condicional>`%}, a próxima versão do index.html faz uso disso como exemplo:

*app/templates/index.html* :
```html
<html>
    <head>
        {% if title %}
        <title>{{title}} - Microblog</title>
        {% else %}
        <title>Welcome to Microblog</title>
        {% endif %}
    </head>
    <body>
        <h1>Hello, {{ user .username }}!</h1>
    </body>
</html>
```

Este código é um pouquinho mais inteligente e considera que se a função em python passar um título, este será adicionado a tab do website. Se não, o título default *Welcome to Microblog* será colocado no lugar, tudo utilizando condicionais no template realizado no index.html. As duas formas podem ser vistas na figura 3.

![figura3](modelo3.png)
`Figura 3 - Titulo do site modificado através da condicional com e sem título nos parâmetros da chamada do render template, respectivamente.`

Na segunda forma, simplesmente foi suprimido o `title = home` do código em `routes.py`.
****

**Loops em Jinja2:**

O curso introduz o conceito de loops feitos no template utilizando Jinja2. Ele cria uma lista em `routes.py` de posts que poderão ser vistos no site modelo. O código em python fica:

*/app/routes.py:*
```python
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
            'body': 'Adorei o ultimo filme do Ari Aster'
        }
    ]
    return render_template('index.html', title='Home', user=user, posts=posts)
```

A sintaxe utilizada em posts determina uma lista que contém um autor e um corpo e é passada como parâmetro no final do código para o *render_template*, que o executa utilizando o tempalte criado em *index.hmtl*.

A listas de posts pode ter tamanho variável, por isso foi necessário criar um loop e percorrer toda a lista. O Jinja2 oferece o controlador **for** para essa probelmática, deixando o código da seguinte forma:

*/app/templates/index.html* :
```html
<html>
    <head>
        {% if title %}
        <title>{{ title }} - Microblog</title>
        {% else %}
        <title>Welcome to Microblog</title>
        {% endif %}
    </head>
    <body>
        <h1>Hi, {{ user.username }}!</h1>
        {% for post in posts %}
        <div><p>{{ post.author.username }} diz: <b>{{ post.body }}</b></p></div>
        {% endfor %}
    </body>
</html>
```
O resultado dessa modificação pode ser vista na figura 4.1 (com dois posts) e na figura 5 (com três posts), sendo que a única modificação feita foi a adição do post final a lista em `routes.py`.

![figura4](modelo4.png)

`Figura 4 - Utilização de loop para a criação de estrutura de repetição com dois posts.`

![figura5](modelo5.png)

`Figura 5 - Utulização de loop para a criação de estrutura de repetição com três posts.`

****

**Herança de Templates:**

Se há uma sessão que estará presente em todas as páginas de um site, é possível criar um template único e herdá-lo para outros templates.

Aqui foi movido uma base para um outro arquivo, chamado `base.html`, onde será colocada uma estrutura base que poderá ser invocada pelo template `index.html` ou por qualquer outro de outra página. No caso deste exemplo será uma simples barra de navegação.

*/app/templates/base.html* :

```html
<html>
    <head>
      {% if title %}
      <title>{{ title }} - Microblog</title>
      {% else %}
      <title>Welcome to Microblog</title>
      {% endif %}
    </head>
    <body>
        <div>Microblog: <a href="/index">Home</a></div>
        <hr>
        {% block content %}{% endblock %}
    </body>
</html>
```
O controlador {% block content %}{% endblock %} define o local onde o código de um outro arquivo html que extende `base.html` será implementado automaticamente. Além disso foi criado um link no corpo desta base, que aponta para este mesmo site. A sintaxe do link pode ser compreendida no documento HTML já apresentado neste github.

O código de `index.html` fica um pouco diferente, apenas extendendo o código de `base.html`:

*/app/templates/index.html* :
```html
{% extends "base.html" %}

{% block content %}
    <h1>Hi, {{ user.username }}!</h1>
    {% for post in posts %}
    <div><p>{{ post.author.username }} says: <b>{{ post.body }}</b></p></div>
    {% endfor %}
{% endblock %}
```
Aqui, o `base.html` toma conta do título e de toda a estrutura do site, e o `index.html` o extende, implementando a parte específica dessa página. O controlador Jinja2 {% extends "`arquivo_base`" %} faz com que um arquivo html se insira entre o ramo {% block content %} do arquivo base mencionado. 

Se for necessário criar outra página com a mesma estrutura, neste caso, é possível fazer um outro arquivo html que também extende o `base.html` e serão garantidas à ele todas as características que o `index.html` herda neste exemplo. O resultado pode ser visto na figura 6.

![figura6](modelo6.png)
`Figura 6 - Site executado com base e implementação com herança de templates`

Pode ser observada a estrutura combinada dos dois códigos, da `base.html` que implementa a esturutra e coloca o link que pode ser visto no topo da página, e também do `index.html` que implementa a saudação e a lista de posts.