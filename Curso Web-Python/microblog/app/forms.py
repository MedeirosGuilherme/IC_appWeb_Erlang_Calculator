from flask_wtf import FlaskForm
from wtforms import StringField, PaswordField, BooleanField, SubmitField
from wtforms.validators import DataRequired

class LoginForm(FLaskForm):
    username = StringField('Username', validators=[DataRequired()])
    password = PaswordField('Password', validators=[DataRequired()])
    remember_me = BooleanField('Remember Me')
    submit = SubmitField('Sign In')
