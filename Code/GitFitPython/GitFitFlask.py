from flask import Flask, request, jsonify, session, redirect, url_for, render_template
import pymysql
import pymysql.cursors

app = Flask(__name__)

# Uncomment and configure your database connection properly if needed
# conn = pymysql.connect(
#     host='localhost',
#     user='root',
#     password='1234',
#     database='persone',
#     cursorclass=pymysql.cursors.DictCursor,
#     autocommit=True
# )

@app.route("/", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        name = request.form.get("name")
        surname = request.form.get("surname")
        weight = request.form.get("weight")
        age = request.form.get("age")
        goal = request.form.get("goal")
        username = request.form.get("username")
        password = request.form.get("password")

        # Validate input
        if not all([name, surname, weight, age, goal, username, password]):
            return "<h3>All fields are required!</h3>", 400

        # Simulate saving data (replace with database logic if needed)
        user_data = {
            "name": name,
            "surname": surname,
            "weight": weight,
            "age": age,
            "goal": goal,
            "username": username,
            "password": password  # Replace with hashed password in production
        }
        print("Received data:", user_data)  # Debugging output

        return redirect(url_for("success"))

    return render_template("form.html")

@app.route("/success")
def success():
    return "<h2>Registration completed successfully!</h2>"

if __name__ == "__main__":
    app.run(debug=True, port=8000)