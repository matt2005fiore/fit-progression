
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

<<<<<<< HEAD
# Simula un database in memoria
users = [
    {
    "username":"testuser",
    "password": "password123"
    },
    {
    "username":"testuser2",
    "password": "password12345"
    }
    ]

# configurazione del database
# conn = pymysql.connect(
#     host='localhost',
#     user='root',
#     password='1234',
#     database='persone',
#     cursorclass=pymysql.cursors.DictCursor,
#     autocommit=True
# )

# Endpoint per il login
@app.route('/login', methods=['POST'])
def login():
    data = request.json
    username = data.get('username')
    password = data.get('password')

    if not username or not password:
        return jsonify({"error": "Username e password sono obbligatori."}), 400

    # Verifica le credenziali
    for utente in users:
        if utente.get('username') == username and utente.get('password') == password:
            return jsonify({"message": "Login effettuato con successo."}), 200
        else:
            return jsonify({"error": "Credenziali non valide."}), 401


# Endpoint per la registrazione
@app.route('/register', methods=['POST'])
def register():
    data = request.json
    username = data.get('username')
    password = data.get('password')

    if not username or not password:
        return jsonify({"error": "Username e password sono obbligatori."}), 400

    if username in users:
        return jsonify({"error": "Username gia esistente."}), 409

    users[username] = password
    return jsonify({"message": "Registrazione completata con successo."}), 201

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True, port=5000)
=======
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
>>>>>>> 43dfeeae3fa30a00f77d2e410effbe07ebccb069
