import requests
import string

def send_default_request():
	URL = "http://localhost:8080/greeting"
	return send(URL,"")

def send_request(name):
	URL = "http://localhost:8080/greeting"
	PARAMS = {'name':name}
	return send(URL, PARAMS)

def send(URL,PARAMS):
	r = requests.get(url = URL, params = PARAMS)
	print r.text
	return r.status_code


