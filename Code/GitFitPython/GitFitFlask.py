from flask import Flask, request, jsonify
import pymysql

import sys
app = Flask(__name__)

# Database connection
conn = pymysql.connect(
    host='localhost',
    user='root',
    password='1234',
    database='persone',
    cursorclass=pymysql.cursors.DictCursor,
    autocommit=True
)
cursor = conn.cursor()

# Endpoint to get all users
@app.route('/users', methods=['GET'])
def get_users():
    cursor.execute("SELECT * FROM UserProfile")
    users = cursor.fetchall()
    return jsonify(users), 200

# Endpoint to create a new user
@app.route('/users', methods=['POST'])
def create_user():
    data = request.get_json()
    if not data or 'firstname' not in data or 'surname' not in data:
        return jsonify({'error': 'Invalid input'}), 400

    query = ("INSERT INTO UserProfile (firstname, surname, weight, height, gender, eMail, codice) "
            "VALUES (%s, %s, %s, %s, %s, %s, %s)")
    values = (data['firstname'], data['surname'], data.get('weight', 0.0),
            data.get('height', 0), data.get('gender', True),
            data.get('eMail', ''), data.get('codice', ''))

    try:
        cursor.execute(query, values)
        conn.commit()
        return jsonify({'message': 'User created successfully'}), 201
    except pymysql.MySQLError as err:  # Correct error handling
        return jsonify({'error': str(err)}), 500

# Endpoint for user login
@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    email = data.get('eMail')
    password = data.get('password')

    if not email or not password:
        return jsonify({'message': 'Email and password are required'}), 400

    cursor.execute("SELECT * FROM UserProfile WHERE eMail = %s", (email,))
    user = cursor.fetchone()

    if user and user['password'] == password:  # Compare passwords (hashed in real cases)
        return jsonify({'message': 'Login successful', 'user': user}), 200
    else:
        return jsonify({'message': 'Invalid credentials'}), 401
    




print(sys.version)
print(__file__)


if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=5000)
