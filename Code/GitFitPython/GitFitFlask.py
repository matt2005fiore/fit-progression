from flask import Flask, request, jsonify
import pymysql
import pymysql.cursors
app = Flask(__name__)
conn = pymysql.connect(
 host='localhost',
 user='root',
 password='1234',
 database='persone',
 cursorclass=pymysql.cursors.DictCursor,
 autocommit=True
)