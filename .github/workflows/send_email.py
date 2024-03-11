import smtplib
import ssl
import os

# Get the directory of the current script
script_dir = os.path.dirname(os.path.abspath(__file__))
# Construct the full path to the send_email.py file
send_email_path = os.path.join(script_dir, 'send_email.py')

port = 465
smtp_server = "smtp.gmail.com"
USERNAME = os.environ.get('USER_EMAIL')
PASSWORD = os.environ.get('USER_PASSWORD')
message = """\
Subject: GitHub Email Report

This is your daily email report.
"""

context = ssl.create_default_context()

try:
    with smtplib.SMTP_SSL(smtp_server, port, context=context) as server:
        server.login(USERNAME, PASSWORD)
        server.sendmail(USERNAME, USERNAME, message)
except Exception as e:
    print(f"An error occurred: {e}")
