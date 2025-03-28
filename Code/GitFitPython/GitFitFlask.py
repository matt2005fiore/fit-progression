from flask import Flask, request, jsonify, session, redirect, url_for, render_template
import pymysql
import pymysql.cursors

app = Flask(__name__)

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
