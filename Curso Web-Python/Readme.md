# Curso de Desenvolvimento de Aplicação Web em Python produzido por Miguel Grinberg.

[Site do Curso](https://blog.miguelgrinberg.com/post/the-flask-mega-tutorial-part-i-hello-world)

## Aula1: Instalando e criando primeira aplicação:

A aplicação utiliza o pacote FLASK do python3.

**1. Preparando as ferramentas:**

Foi criado um diretório, dentro foi criado um ambiente virtual:

> $ python3 -m venv venv

O comando cria um diretório venv onde um ambiente virtual pode ser criado. O ambiente virtual é ativado usando o comando:

> $ source venv/bin/activate

> (venv) $ -

O terminal passa a executar os comandos pelo ambiente virtual.
Todo esse sistema foi criado para garantir o funcionamento do Flask na versão atual intacta.

Neste momento o Flask pode ser instalado dentro do ambiente virtual, como se instala qualquer outro pacote em python:

> $ (venv) $ pip install flask

**2. A primeira aplicação: Hello World**

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

Para encurtar futuras execuções, o comando ao flask pode ser resumido criando um arquivo .flaskenv na raíz do diretório contendo:

```bash 
FLASK_APP=microblog.py
```

Para isso funcionar, antes deve ser instalado o pacote dotenv com o comando:

> (venv) $ pip install python-dotenv



