import requests
import string

def send_default_request(endpoint):
	URL = "http://localhost:8080/" + endpoint
	print URL
	return send(URL,"")

def send_request(endpoint,name):
	URL = "http://localhost:8080/" + endpoint
	PARAMS = {'name':name}
	print URL
	return send(URL, PARAMS)

def send(URL,PARAMS):
	r = requests.get(url = URL, params = PARAMS)
	return r.status_code


