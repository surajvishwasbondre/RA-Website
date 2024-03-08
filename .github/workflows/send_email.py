import smtplib, ssl
import os


port = 465
smtp_server = "smtp.gmail.com"
USERNAME = os.environ.get('USEREMAIL')
PASSWORD = os.environ.get('USERPASSWORD')
message = """\
Subject: GitHub Email Report

This is Affiliate Marketing Lp's email report.
"""

context = ssl.create_default_context()
with smtplib.SMTP_SSL(smtp_server, port, context=context) as server:
    server.login(USERNAME,PASSWORD)
    server.sendmail(USERNAME,USERNAME,message)