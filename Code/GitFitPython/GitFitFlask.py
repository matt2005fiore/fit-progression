
from flask import Flask, request, jsonify, session
import pymysql
import pymysql.cursors
app = Flask(__name__)
#conn = pymysql.connect(
 #host='localhost',
 #user='root',
 #password='1234',
 #database='persone',
 #cursorclass=pymysql.cursors.DictCursor,
 #autocommit=True
#)

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        name = request.form["name"]
        surname = request.form["surname"]
        weight = request.form["weight"]
        age = request.form["age"]
        goal = request.form["goal"]
        username = request.form["username"]
        password = request.form["password"]

        # Simuliamo il salvataggio dei dati (puoi sostituire con un database)
        user_data = {
            "name": name,
            "surname": surname,
            "weight": weight,
            "age": age,
            "goal": goal,
            "username": username,
            "password": password
        }
        print("Dati ricevuti:", user_data)  # Debug, stampa nel terminale

        return redirect(url_for("success"))  # Reindirizza a una pagina di successo

    return render_template("form.html")

@app.route("/success")
def success():
    return "<h2>Registrazione completata con successo!</h2>"

if __name__ == "__main__":
    app.run(debug=True)
