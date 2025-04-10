from flask import Flask, request, jsonify
import pymysql

app = Flask(__name__)

# Database connection
conn = pymysql.connect(
    host='localhost',
    user='root',
    password='1234',
    database='gitfit',
    cursorclass=pymysql.cursors.DictCursor,
    autocommit=True
)
cursor = conn.cursor()
from flask import Flask, request, jsonify
import pymysql

app = Flask(__name__)

@app.route('/user', methods=['POST'])
def create_user():
    data = request.get_json()
    print("Dati ricevuti:", data)  # Debug

    query = """
    INSERT INTO UserProfile 
    (firstname, surname, weight, height, eMail, codice, gender) 
    VALUES (%s, %s, %s, %s, %s, %s, %s)
    """
    
    values = (
        data.get('firstname', ''),       # firstname
        data.get('surname', ''),    # surname
        float(data.get('weight', 0.0)),
        float(data.get('height', 0.0)),
        data.get('email', ''),
        data.get('password', ''),   # Mappa 'password' su 'codice'
        data.get('gender', False)
    )

    try:
        with conn.cursor() as cursor:
            cursor.execute(query, values)
            conn.commit()
        return jsonify({'message': 'User created successfully'}), 201
        ù
    except pymysql.MySQLError as err:
        print("Errore database:", err)  
        return jsonify({'error': str(err)}), 500
    

@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    email = data.get('email')  # Oppure 'username' se lo usi nel frontend
    codice = data.get('password')  # O 'password' se il frontend lo invia così

    print("login", email, codice)
    if not email or not codice:
        return jsonify({'message': 'Email e codice obbligatori'}), 400

    # Cerca l'utente nella tabella UserProfile (non 'codice'!)
    cursor.execute("SELECT * FROM UserProfile WHERE eMail = %s AND codice = %s", (email, codice))
    user = cursor.fetchone()

    if user:
         return jsonify({
            'message': 'Login successful',
            'user': {  # Invia i dati necessari al frontend
                'firstname': user['firstname'],
                'codice': user['codice'],
                'eMail': user['eMail']
            }
        }), 200
    else:
        return jsonify({'message': 'Credenziali non validi'}), 401
    

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=5000)
